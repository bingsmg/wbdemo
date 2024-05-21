package live.clover.map;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weibb
 * @date 2023-12-22
 */
public class ConcurrentHashMapSC {

    @Test
    public void test1() {
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>(16);
        concurrentHashMap.put("Hello", "world");
    }
}
