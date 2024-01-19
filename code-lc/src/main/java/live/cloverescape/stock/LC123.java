package live.cloverescape.stock;

/**
 * @author weibb
 * @date 2024-01-05
 */
public class LC123 {



    /**
     * 输入：prices = [3,3,5,0,0,3,1,4]
     * 输出：6
     * 股票持有状态 1；
     * 股票未持有状态 0；
     * @param prices 股票价格数组
     * @return 最大价值
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i-1]);
        }
        maxProfit = dp[prices.length-1][0];
        return maxProfit;
    }
}
