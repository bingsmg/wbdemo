package live.cloverescape.lc;

import java.util.Arrays;

/**
 * @author seven
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
}

class Solution {
    public String reverseWords(String s) {
        String ori = reverse(s.trim());
        int p = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ori.length(); i++) {
            char c = ori.charAt(i);
            if (Character.isWhitespace(c)) {
                p = i;
            }
            if (p < i) {
                p++;
                res.append(reverse(ori.substring(p, i)));
            }
        }

        return res.toString();
    }

    public String reverse(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i <= n / 2; i++) {
            char c = chars[i];
            chars[i] = chars[n-1-i];
            chars[n-1-i] = c;
        }
        return Arrays.toString(chars);
    }
}