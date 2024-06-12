package live.clover.threadop.sync;

import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadA threadA = new ThreadA(publicVar);
        threadA.start();

        TimeUnit.SECONDS.sleep(1);

        publicVar.getValue();
    }
}
