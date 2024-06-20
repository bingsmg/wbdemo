package live.clover.cmap;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author weibb
 */
public class HashMapDeadCircular {
    public static void main(String[] args) throws InterruptedException {
        final Map<String, String> map = new HashMap<>(2);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> {
                    map.put(UUID.randomUUID().toString(), "");
                }, "ftf" + i).start();
            }
        }, "ftf");
        t.start();
        t.join();
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
