package live.cloverescape.lc.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 * @date 2023-10-16
 */
public class H76 {
    public static void main(String[] args) {
        H76 h76 = new H76();
        System.out.println(h76.minWindow("A", "A"));
    }


    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        int len = s.length() + 1, ansL = -1, ansR = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.merge(t.charAt(i), 1, Integer::sum);
        }

        Map<Character, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            char c  = s.charAt(r);
            if (map.containsKey(c)) {
                cnt.merge(c, 1, Integer::sum);
            }
            while (check(map, cnt) && l <= r) {
                cnt.merge(s.charAt(l), -1, Integer::sum);
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                l++;
            }
            r++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> cnt) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (cnt.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
