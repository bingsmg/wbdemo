package live.clover.lock.e3;

import org.junit.Test;

/**
 * @author weibb
 */
public class Run {

    @Test
    public void test1() throws InterruptedException {
        MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();

        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();

        Thread.sleep(3000);

        myService.signalAll_A();
    }
}
