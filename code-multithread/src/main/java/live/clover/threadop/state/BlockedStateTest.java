package live.clover.threadop.state;

import java.util.concurrent.locks.LockSupport;

/**
 * 测试 blocked 状态
 * @author weibb
 */
public class BlockedStateTest {
    public static void main(String[] args) {
        BlockedStateTest blockedStateTest = new BlockedStateTest();
        Thread aThread = new Thread(blockedStateTest::test, "aThread");
        Thread bThread = new Thread(blockedStateTest::test, "bThread");
        aThread.start();
        bThread.start();
        System.out.println(aThread.getName() + ": " + aThread.getState());
        System.out.println(bThread.getName() + ": " + bThread.getState());
    }

    private synchronized void test() {
        try {
            LockSupport.park();
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
