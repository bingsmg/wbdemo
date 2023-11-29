package live.cloverescape.lc.stock;

/**
 *  买卖股票的最佳时机
 *  dp[i][k]
 * @author weibb
 * @date 2023-11-21
 */
public class LC121 {

    public static void main(String[] args) {
        LC121 lc121 = new LC121();
        System.out.println(lc121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i-1]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i-1]);
        }

        return dp[prices.length][0];
    }
}
