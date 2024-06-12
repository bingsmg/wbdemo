package live.cloverescape.lc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 今日开始每日一题，今天是算法题：
 * 给你一个仅由小写英文字母组成的字符串 s。
 * 如果一个字符串仅由单一字符组成，那么它被称为特殊字符串。例如，字符串"abc"不是特殊字符串，而字符串"ddd"、"zz"和"f"是特殊字符串。
 * 返回在 s 中出现至少三次的最长特殊子字符串的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1。
 * 子字符串是字符串中的一个连续非空字符序列。
 * @author weibb
 */
public class DailyTopic1 {
    public static void main(String[] args) {
        String s = "abcccaaabbb";
        int n = s.length();
        int i = 0;
        Map<String, Integer> map = new HashMap<>();
        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            String subStr = s.substring(i, j);
            map.merge(subStr, 1, Integer::sum);
            i = j;
        }
        System.out.println(map);
    }
}
