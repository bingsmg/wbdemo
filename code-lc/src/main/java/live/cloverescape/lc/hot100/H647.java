package live.cloverescape.lc.hot100;

import java.util.Arrays;
import java.util.List;

/**
 * 回文子串
 * 最简单的思考方式就是遍历所有子串，判断是否是回文串，遍历需要 O(n2) 复杂度，
 * 判断是否是回文穿需要 O(n) 复杂度，所以总体需要 O(n3) 复杂度有一些高。
 * 可以使用动态规划去做这个题目，状态：dp[i][j] 表示字符串 s 在 [i,j] 区间的子串是否是一个回文串。
 * 状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为 false
 * 所以我们去遍历所有的串，然后通过更新 dp 数组就可以得到最终的结果。
 * 动态规划把空间复杂度降低为 O(N)，但是还有一种更好地处理回文串的方法，其实和动态的思想差不多，就是
 * 利用它左右对称所以向两边同时扩展去减少循环次数提升效率，这就是中心扩展算法，具体思想就是从所有的中心点去扩展
 * 所有的子串，然后每次扩展的两个字符如果相等说明它就是回文串，举例：ababa
 * 它的所有子串：a,ab,b,ba,a,ab,b,ba,a 可以看到它的所有扩展中心有 2*len - 1 个，规律如此可以画个二叉树
 * 得到所有的中心点可能，这里包含了偶数个中心点的情况，因为单字符无法覆盖所有的情况。
 * 然后可以观察子串下标在偶数和奇数的情况，其实可以看到 l = center / 2, r = center / 2 + center % 2。
 * 比如：center = 0, l = 0, r = 0; center  = 1, l = 0, r = 1; 就覆盖了 a, ab 两种情况。
 *      center = 2, l = 1, r = 1; center = 3, l = 1, r = 2; 就覆盖了 b, ba 两种情况。
 *      center = 8，l = 4, r = 4，覆盖了 a 的情况，
 * @author weibb
 * @date 2023-10-09
 */
public class H647 {
    public static void main(String[] args) {
        H647 h647 = new H647();
        List<String> demos = Arrays.asList("abc", "abab", "ababa");
        for (String demo : demos) {
            System.out.println(h647.countSubstrings(demo));
            System.out.println(h647.countSubstringsDp(demo));
            System.out.println(h647.countSubstringsCenterExtension(demo));
            System.out.println("--------------------------------");
        }
    }

    public int countSubstrings(String s) {
        int cnt = 0;
        char[] carr = s.toCharArray();
        for (int i = 0; i < carr.length; i++) {
            for (int j = i; j < carr.length; j++) {
                char[] subArr = Arrays.copyOfRange(carr, i, j+1);
                if (judgeIsBackWriting(subArr)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean judgeIsBackWriting(char[] carr) {
        int n = carr.length;
        for (int i = 0; i < n / 2; i++) {
            if (carr[i] != carr[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public int countSubstringsDp(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans ++;
                }
            }
        }
        return ans;
    }

    public int countSubstringsCenterExtension(String s) {
        int ans = 0;
        int n = s.length() * 2 - 1;
        for (int i = 0; i < n; i++) {
            int l = i / 2;
            int r = i / 2 + i % 2;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                ans ++;
                l--;
                r++;
            }
        }
        return ans;
    }
}
