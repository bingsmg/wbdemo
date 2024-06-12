package live.clover.threadcomm.tl;

/**
 * @author weibb
 */
public class ThreadA extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("ThreadA fetch value = " + Tools.tl.get() + " (by ThreadLocal)");
                Thread.sleep(100);
                System.out.println("ThreadA fetch value = " + Tools.itl.get() + " (by InheritableThreadLocal)");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
