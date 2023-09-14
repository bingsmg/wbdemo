package live.clover.multithread.case3;

/**
 * @author weibb
 * @date 2023-08-30
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
    }
}
