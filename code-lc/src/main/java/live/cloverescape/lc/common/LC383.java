package live.cloverescape.lc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 * @date 2023-11-09
 */
public class LC383 {
    public static void main(String[] args) {
        LC383 lc383 = new LC383();
        System.out.println(lc383.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            charMap.merge(magazine.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (charMap.get(c) == null || charMap.get(c) == 0) {
                return false;
            } else {
                charMap.merge(c, -1, Integer::sum);
            }
        }
        return true;
    }
}
