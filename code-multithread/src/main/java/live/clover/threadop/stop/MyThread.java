package live.clover.threadop.stop;

/**
 * @author weibb
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500; i++) {
            System.out.println("i = " + (i + 1));
            if (i == 200) {
                this.interrupt();
                System.out.println(Thread.currentThread().getName() + " Whether stop ?"
                        + Thread.currentThread().isInterrupted() + " Current i = " + i);
            }
        }
    }
}
