package live.clover.threadop.state;

/**
 * @author weibb
 */
public class ThreadState {
    private static Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println(Thread.currentThread().getState());
                    for (int i = 0; i < 10; i++) {
                        lock.wait();
                        System.out.println("invoke lock wait 方法后: " + Thread.currentThread().getState());
                        System.out.println(Thread.currentThread().getName() + " i");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadA.setName("threadA");
        System.out.println(threadA.getState());
        threadA.start();
    }
}
