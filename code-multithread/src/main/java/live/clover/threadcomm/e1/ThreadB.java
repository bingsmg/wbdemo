package live.clover.threadcomm.e1;

/**
 * @author weibb
 */
public class ThreadB extends Thread {

    private final MyList list;

    public ThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000); // 添加该行后 B 线程无法退出
                if (list.size() == 5) {
                    System.out.println("exit!!!!!!!!!!!!!!!!!!!!!!!!!");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
