package live.clover.map;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author weibb
 */
public class TreeMapSC {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 17; i++) {
            int key = random.nextInt(30);
            System.out.print(key + "->");
            treeMap.put(key, "element" + i);
        }
        System.out.println();
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.firstKey());
        treeMap.headMap(3).keySet().forEach(System.out::println);
        treeMap.tailMap(3).keySet().forEach(System.out::println);
    }
}
