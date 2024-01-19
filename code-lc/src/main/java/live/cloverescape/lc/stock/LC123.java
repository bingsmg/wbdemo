package live.cloverescape.lc.stock;

/**
 * @author weibb
 * @date 2024-01-09
 */
public class LC123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n-1][3][2];
        dp[0][1][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i]); // dp[i-1][0][0] 其实只会用到一次，所以直接去掉也行
        }
        return dp[n-1][2][0];
    }
}
