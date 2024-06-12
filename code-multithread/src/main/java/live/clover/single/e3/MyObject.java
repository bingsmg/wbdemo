package live.clover.single.e3;

/**
 * @author weibb
 */
public class MyObject {

    private static class MyObjectHolder {
        private static MyObject instance = new MyObject();
    }

    private MyObject() {}

    private static MyObject getInstance() {
        return MyObjectHolder.instance;
    }
}
