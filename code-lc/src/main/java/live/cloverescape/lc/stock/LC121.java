package live.cloverescape.lc.stock;

/**
 * 只能进行 1 次交易
 * @author weibb
 * @date 2023-11-21
 */
public class LC121 {

    public static void main(String[] args) {
        LC121 lc121 = new LC121();
        System.out.println(lc121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]); // 一次交易,所以今天的操作是 rest 或者 买入，买入的话因为这是第一次买入，所以与之前的收益无关
        }

        return dp[n-1][0];
    }

    public int maxProfit2(int[] prices) {
        int profit0 = 0, profit1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit0 = Math.max(profit0, profit1 + prices[i-1]);
            profit1 = Math.max(profit1, -prices[i-1]);
        }
        return profit0;
    }
}
