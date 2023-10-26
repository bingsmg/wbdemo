package live.cloverescape.lc.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 * @date 2023-10-16
 */
public class H567 {
    public static void main(String[] args) {
        H567 h567 = new H567();
        System.out.println(h567.checkInclusion("ab", "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> ori = new HashMap<>();
        Map<Character, Integer> cnt = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            ori.merge(s1.charAt(i), 1, Integer::sum);
        }

        int l = 0, r = 0;
        while (r < s2.length()) {
            char c = s2.charAt(r);
            if (ori.containsKey(c)) {
                cnt.merge(c, 1, Integer::sum);
            }
            if (r - l + 1 == s1.length()) {
                if (check(ori, cnt)) {
                    return true;
                }
                if (cnt.containsKey(s2.charAt(l))) {
                    cnt.put(s2.charAt(l), cnt.get(s2.charAt(l)) - 1);
                }
                l++;
            }
            r++;
        }
        return false;
    }

    private boolean check(Map<Character, Integer> ori, Map<Character, Integer> cnt) {
        for (Map.Entry<Character, Integer> entry : ori.entrySet()) {
            if (!cnt.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
