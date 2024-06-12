package live.clover.threadcomm.e4;

/**
 * @author weibb
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);

        Thread[] threadP = new Thread[2];
        Thread[] threadC = new Thread[2];

        for (int i = 0; i < 2; i++) {
            threadP[i] = new Thread(p::setValue, "producer" + (i + 1));
            threadC[i] = new Thread(c::getValue, "consumer" + (i + 1));
            threadP[i].start();
            threadC[i].start();
        }

        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }
    }
}
