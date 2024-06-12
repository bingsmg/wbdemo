package live.clover.single.e1;

/**
 * @author weibb
 */
public class MyObject {
    // 立即加载/饿汉式
    private static MyObject object = new MyObject();

    private MyObject() {}

    public static MyObject getInstance() {
        return object;
    }
}
