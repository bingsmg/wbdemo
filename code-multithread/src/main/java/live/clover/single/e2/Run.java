package live.clover.single.e2;

import org.junit.Test;

/**
 * @author weibb
 */
public class Run {

    @Test
    public void test1() {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.start();
        t2.start();
        t3.start();
    }
}
