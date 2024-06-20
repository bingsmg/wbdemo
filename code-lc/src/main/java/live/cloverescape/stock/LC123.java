package live.cloverescape.stock;

/**
 * @author weibb
 * @date 2024-01-05
 */
public class LC123 {

    public static void main(String[] args) {
        int maxProfit = new LC123().maxProfit(new int[]{1, 2, 3, 4, 5});
        System.out.println(maxProfit);
    }

    /**
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 股票持有状态 1；
     * 股票未持有状态 0；
     * @param prices 股票价格数组
     * @return 最大价值
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2; // 两次交易次数
        if (n == 0) return 0;
        // dp[i][j][0] 表示第 i 天最多进行了 j 次交易后不持有的最大收益
        // dp[i][j][1] 表示第 i 天最多进行了 j 次交易后持有的最大收益
        // 我们把买入就认为是一次交易
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            // 不可能的情况
            dp[i][0][1] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                // i 天 rest / sell
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                // i 天 rest / buy
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
