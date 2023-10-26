package live.cloverescape.lc.hot100;

import java.util.*;

/**
 * "cbaebabacd", p = "abc" 返回：[0,6]
 * "abab", p = "ab" 返回：[0,1,2]
 * @author weibb
 * @date 2023-10-16
 */
public class H438 {
    public static void main(String[] args) {
        H438 h438 = new H438();
        System.out.println(Arrays.toString(h438.findAnagrams("cbaebabacd", "abc").toArray()));

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> ori = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            ori.merge(p.charAt(i), 1, Integer::sum);
        }
        Map<Character, Integer> cnt = new HashMap<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (ori.containsKey(c)) {
                cnt.merge(c, 1, Integer::sum);
            }
            if (r - l + 1 == p.length()) {
                if (check(ori, cnt)) {
                    ans.add(l);
                }
                cnt.merge(s.charAt(l++), -1, Integer::sum);
            }
            r++;
        }
        return ans;
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
