package live.clover;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author weibb
 * @date 2023-12-21
 */
public class HashMapTest {

    @Test
    public void test1() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("Hello", "World");
    }
}
