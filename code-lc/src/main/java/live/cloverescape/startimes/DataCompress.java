package live.cloverescape.startimes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author weibb
 */
public class DataCompress {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputStr;
        while ((inputStr = reader.readLine()) != null) {
            System.out.println(minCut(inputStr));
        }
    }

    private static int minCut(String s) {
        int n = s.length();
        // judge[l][r]表示 s[l:r] 子串是否为回文串
        boolean[][] judge = new boolean[n+1][n+1];
        for (int r = 1; r <= n; r++) {
            for (int l = r; l >= 1; l--) {
                if (l != r) {
                    if (s.charAt(l - 1) == s.charAt(r - 1)) {
                        if (r - l == 1 || judge[l + 1][r - 1]) {
                            judge[l][r] = true;
                        }
                    }
                } else {
                    judge[l][r] = true;
                }
            }
        }
        // dp[i] 表示将 s[1:i] 分割为若干回文串需要的最小分割次数
        int[] dp = new int[n + 1];
        for (int r = 1; r <= n; r++) {
            if (judge[1][r]) dp[r] = 0;
            else {
                // 需要分割的最大次数为长度-1
                dp[r] = r - 1;
                for (int l = 1; l <= r; l++) {
                    if (judge[l][r]) dp[r] = Math.min(dp[r], dp[l-1] + 1);
                }
            }
        }
        return dp[n];
    }
}
