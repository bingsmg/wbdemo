package live.clover.threadcomm.tl;

/**
 * @author weibb
 */
public class Tools {
    public static ThreadLocal<String> tl = new ThreadLocal<>(); // main 线程里创建出的其他线程为 main 的子线程，不具备继承
    public static InheritableThreadLocal<String> itl = new InheritableThreadLocal<>(); // 具备继承性质
}
