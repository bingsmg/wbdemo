package live.clover.threadop.stop;

import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            TimeUnit.SECONDS.sleep(1);
            myThread.interrupt();
            Thread.currentThread().interrupt();
            System.out.println("whether stop 1? " + Thread.interrupted());
            System.out.println("whether stop 2? " + Thread.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
