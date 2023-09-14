package live.clover.multithread.case3;

/**
 * @author weibb
 * @date 2023-08-30
 */
public class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.await();
    }
}
