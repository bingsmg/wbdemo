package live.clover.threadcomm.e4;

/**
 * @author weibb
 */
public class P {

    private String lock;

    public P(String lock) {
        super();
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("producer " + Thread.currentThread().getName() + " waiting.");
                    lock.wait();
                }
                System.out.println("producer " + Thread.currentThread().getName() + " runnable.");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
