package live.clover.threadcomm.tl;

/**
 * @author weibb
 */
public class Run {

    public static ThreadLocal<String> t1 = new ThreadLocal<>();
    public static ThreadLocalExt threadLocalExt = new ThreadLocalExt();

    public static void main(String[] args) {
        if (t1.get() == null) {
            System.out.println("not set value");
            t1.set("any value");
        }
        System.out.println(t1.get());
        System.out.println(threadLocalExt.get());
    }
}
