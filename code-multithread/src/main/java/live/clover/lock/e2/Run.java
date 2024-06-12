package live.clover.lock.e2;

import org.junit.Test;

/**
 * @author weibb
 */
public class Run {

    @Test
    public void test1() {
        MyService myService = new MyService();
        ThreadA threadA = new ThreadA(myService);
        threadA.start();
    }

    @Test
    public void test2() {
        MyService myService = new MyService();

        MyThreadA t1 = new MyThreadA(myService);
        t1.start();

        MyThreadA t2 = new MyThreadA(myService);
        t2.start();

        MyThreadA t3 = new MyThreadA(myService);
        t3.start();
    }
}
