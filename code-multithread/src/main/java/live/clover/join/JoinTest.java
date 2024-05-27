package live.clover.join;

import java.util.concurrent.ExecutionException;

/**
 * @author weibb
 * @date 2023-10-24
 */
public class JoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main thread execute start.");
        Sleeper sleeper = new Sleeper("sleeper", 2000);
        Joiner joiner = new Joiner("joiner", sleeper);
        System.out.println("main thread execute finished.");
    }
}
