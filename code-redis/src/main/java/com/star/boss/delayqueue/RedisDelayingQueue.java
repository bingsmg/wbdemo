package com.star.boss.delayqueue;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Type;
import java.util.List;
import java.util.UUID;

/**
 * @author weibb
 */
public class RedisDelayingQueue<T> {

    static class TaskItem<T> {
        public String id;
        public T msg;
    }

    private final Type type = new TypeReference<TaskItem<T>>() {}.getType();
    private Jedis jedis;
    private String queueKey;

    public RedisDelayingQueue(Jedis jedis, String queueKey) {
        this.jedis = jedis;
        this.queueKey = queueKey;
    }

    public void delay(T msg) {
        TaskItem<T> taskItem = new TaskItem<>();
        taskItem.id = UUID.randomUUID().toString();
        taskItem.msg = msg;
        String s = JSON.toJSONString(taskItem);
        jedis.zadd(queueKey, System.currentTimeMillis() + 5000, s);
    }

    public void loop() {
        while (!Thread.interrupted()) {
            List<String> values = jedis.zrangeByScore(queueKey, 0, System.currentTimeMillis(), 0, 1);
            if (values.isEmpty()) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
                continue;
            }
            String s = values.iterator().next();
            if (jedis.zrem(queueKey, s) > 0) {
                TaskItem<T> o = JSON.parseObject(s, type);
                // process(o)
            }
        }
    }
    // 使用 join() 和 Thread.interrupted() 的方式可以让程序在生产者-消费者模式下更加安全和可控。
    // 生产者线程负责添加任务,消费者线程负责处理任务,两者通过适当的同步和中断机制协调工作。
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        RedisDelayingQueue queue = new RedisDelayingQueue(jedis, "delay_queue");
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                queue.delay("code" + i);
            }
        });
        Thread consumer = new Thread(() -> queue.loop());
        producer.start();
        consumer.start();
        try {
            // main 线程等待 producer 执行完成，避免主线程过早退出而导致未完成的任务。
            producer.join();
            // 保证消费者线程已经消费了队列所有延时消息
            Thread.sleep(6000);
            // 通知循环结束
            consumer.interrupt();
            // main 线程等待 consumer 执行完成，避免主线程过早退出而导致未完成的任务。
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
