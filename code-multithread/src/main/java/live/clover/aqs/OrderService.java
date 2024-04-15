package live.clover.aqs;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weibb
 */
public class OrderService {

    public static void main(String[] args) {
        HashSet<Object> objects = new HashSet<>();

        System.out.println(objects.contains(null));
    }

    private static final ReentrantLock lock = new ReentrantLock(true);

    public void createOrder() {
        lock.lock();
        try {
            System.out.println("only 1 thread execute.");
            System.out.println(Thread.currentThread().getName() + "  sleep 2 s");
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
