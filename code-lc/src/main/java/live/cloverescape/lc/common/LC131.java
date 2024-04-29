package live.cloverescape.lc.common;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author weibb
 */
public class LC131 {
    public static void main(String[] args) {
        List<List<String>> list = new LC131().partition("aab");
        for (List<String> strings : list) {
            strings.forEach(s -> System.out.print(s + " "));
            System.out.println();
        }
    }
    public List<List<String>> partition(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] dp = new boolean[n][n];
        for (int r = 0; r < n; ++r) {
            for (int l = 0; l <= r; l++) {
                if (cs[l] == cs[r] && (r - l + 1 <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        backtrack(ans, path, dp, n, 0, s);
        return ans;
    }
    private void backtrack(List<List<String>> ans,
                           Deque<String> path,
                           boolean[][] dp,
                           int n,
                           int idx,
                           String s) {
        if (idx == n) ans.add(new ArrayList<>(path));
        for (int i = idx; i < n; i++) {
            if (dp[idx][i]) {
                path.offerLast(s.substring(idx, i + 1));
                backtrack(ans, path, dp, n, i + 1, s);
                path.pollLast();
            }
        }
    }
}
