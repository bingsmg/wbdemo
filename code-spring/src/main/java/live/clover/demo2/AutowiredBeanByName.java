package live.clover.demo2;

/**
 * @author weibb
 * @date 2023-09-26
 */
public class AutowiredBeanByName {
    private A a;
    private B b;
    private C c;


    public AutowiredBeanByName() {
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "AutowiredBean{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
