package live.clover.threadcomm.e4;

/**
 * @author weibb
 */
public class C {

    private String lock;

    public C(String lock) {
        super();
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("")) {
                    System.out.println("consumer " + Thread.currentThread().getName() + " waiting.");
                    lock.wait();
                }
                System.out.println("consumer " + Thread.currentThread().getName() + " runnable.");
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
