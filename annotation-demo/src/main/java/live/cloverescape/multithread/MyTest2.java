package live.cloverescape.multithread;

/**
 * @author weibb
 * @date 2023-08-15
 */
public class MyTest2 {

    public void myMethod() {
        synchronized (this) {
            int age = 100;
        }
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        myTest2.myMethod();
    }
}
