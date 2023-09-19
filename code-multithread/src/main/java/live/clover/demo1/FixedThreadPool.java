package live.clover.demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weibb
 * @date 2023-09-19
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
