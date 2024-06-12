package live.clover.threadcomm.tl;

/**
 * @author weibb
 */
public class Test {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5; i++) {
                if (Tools.tl.get() == null) {
                    Tools.tl.set("this value is putted by main thread!");
                }
                System.out.println("in main thread, fetch value = " + Tools.tl.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);

            System.out.println("\n############### test InheritableThreadLocal ##############\n");

            for (int i = 0; i < 5; i++) {
                if (Tools.itl.get() == null) {
                    Tools.itl.set("this value is putted by main thread! (by InheritableThreadLocal)");
                }
                System.out.println("in main thread, fetch value = " + Tools.itl.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA threadA = new ThreadA();
            threadA.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
