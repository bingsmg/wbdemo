package live.clover.lock.e3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weibb
 */
public class MyService {

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA time is: "
                    + System.currentTimeMillis() + "Thread Name = "
                    + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA time is: "
                    + System.currentTimeMillis() + "Thread Name = "
                    + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB time is: "
                    + System.currentTimeMillis() + "Thread Name = "
                    + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB time is: "
                    + System.currentTimeMillis() + "Thread Name = "
                    + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A time is: "
                    + System.currentTimeMillis() + "Thread Name = "
                    + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B time is: "
                    + System.currentTimeMillis() + "Thread Name = "
                    + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
