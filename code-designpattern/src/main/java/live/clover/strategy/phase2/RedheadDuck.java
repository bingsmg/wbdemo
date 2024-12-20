package live.clover.strategy.phase2;

/**
 * @author weibb
 */
public class RedheadDuck extends Duck {
    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        //...外观红头
    }
}
