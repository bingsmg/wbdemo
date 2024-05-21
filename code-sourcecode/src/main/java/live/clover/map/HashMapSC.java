package live.clover.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * HashMap source code analyse
 * @author weibb
 */
public class HashMapSC {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 33; i++) {
            hashMap.put(i, "element" + i);
        }
        hashMap.put(33, "element33");
        hashMap.put(54, "element54");
        hashMap.put(52, "element52");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        hashMap.get(0);
        hashMap.remove(2);
        hashMap.remove(3, "element3");
        hashMap.containsKey(0);
    }
}
