package live.clover.phasefour.demo1;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class Service implements IService1, IService2{
    @Override
    public void m1() {
        System.out.println("I am m1");
    }

    @Override
    public void m2() {
        System.out.println("I am m2");
    }
}
