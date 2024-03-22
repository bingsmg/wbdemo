package live.cloverescape;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 */
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int res = 0, lo = 0;
        for (int hi = 0; hi < n; ++hi) {
            char c = s.charAt(hi);
            map.merge(c, 1, Integer::sum);
            while (map.size() > k) {
                char t = s.charAt(lo);
                map.merge(t, -1, Integer::sum);
                if (map.get(t) == 0) {
                    map.remove(t);
                }
                lo++;
            }
            res = Math.max(res, hi - lo + 1);
        }
        return res;
    }
}
