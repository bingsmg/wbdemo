package live.clover.strategy.phase2;

/**
 * @author weibb
 */
public class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehavior(new FlyWithWings());
        // 函数式接口
        quackBehavior = () -> System.out.println("quack");
    }

    @Override
    public void display() {
        //...
    }
}
