package live.cloverescape.multithread;

/**
 * @author weibb
 * @date 2023-08-15
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        Service service = new Service();
        service.service1();
    }
}
