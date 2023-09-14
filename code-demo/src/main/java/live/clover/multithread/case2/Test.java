package live.clover.multithread.case2;

/**
 * @author weibb
 * @date 2023-08-30
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyThreadA a = new MyThreadA();
        MyThreadB b = new MyThreadB();
        a.start();
        b.start();
        for (int i = 0; i < 10; i++) {
            Tools.t1.set("main: " + (i+1));
            System.out.println("   main get " + Tools.t1.get());
            int sleepValue = (int)(Math.random() * 1000);
            Thread.sleep(sleepValue);
        }
    }
}
