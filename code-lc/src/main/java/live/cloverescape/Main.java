package live.cloverescape;

import java.util.HashMap;

/**
 * @author weibb
 * @date 2023-11-27
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(1, 1);
        System.out.println(objectObjectHashMap.get(null));
    }
}
