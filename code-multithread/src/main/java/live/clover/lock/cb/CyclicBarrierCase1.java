package live.clover.lock.cb;

import java.util.concurrent.*;

/**
 * 用 Java 的多线程模拟一个赛马，马场上有 10 匹马，要求它们同时跑
 * @author weibb
 */
public class CyclicBarrierCase1 {

    CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static void main(String[] args) {
        CyclicBarrierCase1 case1 = new CyclicBarrierCase1();
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
                    cyclicBarrier.await();
                    System.out.println("Thread: " + Thread.currentThread().getName() + " prepare end,time: " + System.currentTimeMillis());
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}
