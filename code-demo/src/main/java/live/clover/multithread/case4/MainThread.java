package live.clover.multithread.case4;

/**
 * @author weibb
 * @date 2023-09-04
 */
public class MainThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("Waiting for Liftoff");
    }
}
