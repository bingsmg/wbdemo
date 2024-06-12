package live.clover.single.e2;

/**
 * @author weibb
 */
public class MyObject {
    // 延迟加载/懒汉式
    private volatile static MyObject instance;

    private MyObject() {}

    public static MyObject getInstance() {
        if (instance == null) {
//            Thread.sleep(20000); // 模拟创建对象准备耗时工作
            synchronized (MyObject.class) {
                if (instance == null) {
                    instance = new MyObject();
                }
            }
        }
        return instance;
    }
}
