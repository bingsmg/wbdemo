package live.clover.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author weibb
 */
public class LinkedHashMapSC {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < 17; i++) {
            linkedHashMap.put(i, "element" + i);
        }
        linkedHashMap.put(33, "element33");
        linkedHashMap.put(54, "element54");
        linkedHashMap.put(52, "element52");
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
