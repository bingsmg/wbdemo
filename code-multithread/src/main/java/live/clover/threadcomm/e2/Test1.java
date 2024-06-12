package live.clover.threadcomm.e2;

/**
 * @author weibb
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String string = new String("");
            string.wait(); // 无对象监视器/无锁 调用 wait 异常
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
