package live.clover.multithread.case1;

import live.clover.multithread.case2.MyList;

/**
 * @author weibb
 * @date 2023-08-30
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end " + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
