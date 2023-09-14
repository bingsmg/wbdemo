package live.cloverescape;

/**
 * @author weibb
 * @date 2023-08-15
 */
public class MyJob extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        MyJob myJob = new MyJob();
        myJob.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.currentThread().wait();
        }
    }
}
