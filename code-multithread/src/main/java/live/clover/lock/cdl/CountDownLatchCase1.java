package live.clover.lock.cdl;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 用 Java 的多线程模拟一个赛马，马场上有 10 匹马，要求它们同时跑
 * @author weibb
 */
public class CountDownLatchCase1 {

    CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) {
        CountDownLatchCase1 case1 = new CountDownLatchCase1();
        case1.horseRacing();
    }

    private void horseRacing() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(500); // 方便看到输出结果
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            executorService.submit(() -> {
                try {
                    countDownLatch.await();
                    System.out.println("Thread: " + Thread.currentThread().getName() + ", time: " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }
        executorService.shutdown();
    }
}
