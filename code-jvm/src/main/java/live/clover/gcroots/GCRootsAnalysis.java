package live.clover.gcroots;

import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 */
public class GCRootsAnalysis {


    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("live");
        p1.setAge(22);

        Person p2 = new Person();
        p2.setAge(23);
        p2.setName("clover");

        p1.setPerson(p2);

//        new Thread(() -> {
//            while (true) {
//                try {
//                    TimeUnit.SECONDS.sleep(3L);
//                } catch (InterruptedException e) {
//                    System.out.println("e");
//                }
//            }
//        }, "live.clover").start();

        Object myLock = new Object();
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                    synchronized (myLock) {

                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupted exception");
                }
            }
        }, "live.clover").start();
        // 单个线程没有锁，偏向锁，多个线程才会触发 synchronize 的锁升级过程
        synchronized (myLock) {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    System.out.println("interrupted exception");
                }
            }
        }
    }
}

