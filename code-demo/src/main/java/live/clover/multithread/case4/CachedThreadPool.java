package live.clover.multithread.case4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weibb
 * @date 2023-09-04
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
