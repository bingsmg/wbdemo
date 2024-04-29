package live.cloverescape.lc.common;

import java.util.Arrays;

/**
 * @author weibb
 */
public class LC151 {
    public static void main(String[] args) {
        LC151 lc151 = new LC151();
        System.out.println(lc151.reverseWords("the sky is blue"));
    }
    public String reverseWords(String s) {
        s = s.trim();
        int n = s.length();
        char[] cs = s.toCharArray();
        reverse(cs);
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < n) {
            if (cs[i] == ' ') {
                i++;
                continue;
            }
            int j = i;
            while (j < n && cs[j] != ' ') {
                j++;
            }
            char[] subcs = Arrays.copyOfRange(cs, i, j);
            reverse(subcs);
            res.append(String.valueOf(subcs));
            i = j;
        }
        return res.toString();
    }
    private static void reverse(char[] cs) {
        int i = 0, j = cs.length - 1;
        while (i < j) {
            char tmp = cs[i];
            cs[i] = cs[j];
            cs[j] = tmp;
            i++;
            j--;
        }
    }
}
