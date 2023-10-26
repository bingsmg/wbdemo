package live.clover.demo7;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 * @date 2023-10-25
 */
public class WaitNotify {

    static boolean flag = true;
    static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "Wait_Thread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "Notify_Thread");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            synchronized (LOCK) {
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        LOCK.wait();
                    } catch (InterruptedException ignored) {

                    }
                }
                System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {

        @Override
        public void run() {
            synchronized (LOCK) {
                // 获取 LOCK 的锁，然后进行通知，通知时不会释放 LOCK 的锁，直到当前线程释放了 LOCK 后，waitThread 才从 wait 返回
                System.out.println(Thread.currentThread() + " hold lock. notify @ " + new  SimpleDateFormat("HH:mm:ss").format(new Date()));
                LOCK.notifyAll();
                flag = false;
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ignored) {

                }
                synchronized (LOCK) {
                    System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + new  SimpleDateFormat("HH:mm:ss").format(new Date()));
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException ignored) {

                    }
                }
            }
        }
    }
}
