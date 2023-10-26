package live.clover.demo3;

/**
 * @author weibb
 * @date 2023-09-20
 */
public class Joiner extends Thread {

    private final Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    /**
     * 在 joiner 线程驱动的任务里调用 sleeper 线程的 join 方法，则 joiner 线程挂起，sleeper 线程执行完之后 joiner 线程才能继续执行。
     * 但是如果传递了时间参数即 sleeper.join(1000) 则说明 1s 后如果 sleeper 如果还没有返回，join 方法总能返回。
     * join 的底层是 wait 方法实现的，wait 方法会释放被同步对象的锁。
     * 具体调用看{@link live.clover.demo3.JoinTest}
     * @see Thread#join(long)
     */
    @Override
    public void run() {
        try {
            sleeper.join(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
