package live.clover.demo1;

/**
 * @author weibb
 * @date 2023-08-23
 */
public class MyThread extends Thread {
    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public synchronized void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + this.getName() + " 计算， count=" + count);
        }
    }
}
