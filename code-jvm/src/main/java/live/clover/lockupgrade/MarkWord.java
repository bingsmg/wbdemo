package live.clover.lockupgrade;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 */
public class MarkWord {
    public final Object o = new Object();

    public synchronized void demo() {
        synchronized (o) {
            System.out.println("synchronize 代码块内");
            System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getId() + "----" +
                    Integer.toHexString(Thread.currentThread().hashCode()));
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("4s 前");
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
        TimeUnit.SECONDS.sleep(4);

        MarkWord markWord = new MarkWord();
        System.out.println("4s 后");
        System.out.println(Thread.currentThread().getName() + "----" + Thread.currentThread().getId() + "----" +
                Integer.toHexString(Thread.currentThread().hashCode()));
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());

        Thread thread = new Thread(markWord::demo);
        thread.start();
        thread.join();
        System.out.println(ClassLayout.parseInstance(markWord.o).toPrintable());
    }
}
