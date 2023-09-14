package live.cloverescape.multithread;

/**
 * @author weibb
 * @date 2023-08-15
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println(Thread.currentThread());
    }
}
