package live.clover.callable;

import java.util.concurrent.*;

/**
 * @author weibb
 * @date 2023-10-24
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<String> future = exec.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("call" + i);
            }
            return "callable execute success";
        });
        System.out.println(future.get(100, TimeUnit.MILLISECONDS));
        System.out.println("end");
        exec.shutdown();
    }
}
