package live.clover;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author weibb
 * @date 2023-12-22
 */
public class ConcurrentHashMapTest {

    @Test
    public void test1() {
        Map<Object, Object> map = new ConcurrentHashMap<>(16);
        map.put("Hello", "world");
    }
}
