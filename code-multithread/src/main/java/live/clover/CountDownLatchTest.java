package live.clover;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 * @date 2023-12-24
 */
public class CountDownLatchTest {

    @Test
    public void test1() throws InterruptedException {
        final int threadCnt = 20;
        ExecutorService exec = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCnt);
        for (int i = 0; i < threadCnt; i++) {
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(10000, TimeUnit.MILLISECONDS);
        System.out.println("finish");
        exec.shutdown();;
    }
}
