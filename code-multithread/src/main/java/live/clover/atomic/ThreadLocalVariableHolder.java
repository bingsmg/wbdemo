package live.clover.atomic;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author weibb
 * @date 2023-09-21
 */
public class ThreadLocalVariableHolder {
    private static final ThreadLocal<Integer> value = new ThreadLocal<>() {
        private final Random rand = new Random(47);

        @Override
        protected Integer initialValue() {
            return rand.nextInt(1000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(3);
        exec.shutdown();
    }
}
