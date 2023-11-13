package live.cloverescape.lc.common;

/**
 * @author weibb
 * @date 2023-10-30
 */
public class LC1930 {
    //"aabca"
    //"adc"
    //"bbcbaba"
    public static void main(String[] args) {
        LC1930 lc1930 = new LC1930();
        System.out.println(lc1930.countPalindromicSubsequence("aabca"));
    }
    //pre[i] 代表前缀 s[0..i−1]s[0..i-1]s[0..i−1] 包含的字符种类，
    // suf[i] 代表后缀 s[i+1..n−1]s[i+1..n-1]s[i+1..n−1] 包含的字符种类。
    // 那么，以 s[i]s[i]s[i] 为中间字符的回文子序列中，两侧字符的种类对应的状态即为 pre[i]&suf[i]，其中 & 为按位与运算符。
    //
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int res = 0;
        // Prefix and suffix character state arrays
        int[] pre = new int[n];
        int[] suf = new int[n];

        for (int i = 0; i < n; i++) {
            // Prefix s[0..i-1] includes character types
            pre[i] = (i > 0 ? pre[i - 1] : 0) | (1 << (s.charAt(i) - 'a'));
        }

        for (int i = n - 1; i >= 0; i--) {
            // Suffix s[i+1..n-1] includes character types
            suf[i] = (i < n - 1 ? suf[i + 1] : 0) | (1 << (s.charAt(i) - 'a'));
        }

        // Character state arrays for each middle character
        int[] ans = new int[26];
        for (int i = 1; i < n - 1; i++) {
            ans[s.charAt(i) - 'a'] |= (pre[i - 1] & suf[i + 1]);
        }

        // Update the answer
        for (int i = 0; i < 26; i++) {
            res += Integer.bitCount(ans[i]);
        }

        return res;
    }

}
