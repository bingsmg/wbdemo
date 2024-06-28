package live.cloverescape.lc.backpack;

import java.util.Scanner;

/**
 * @author weibb
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 物品种类 M
        int m = sc.nextInt();
        // 背包容量 N
        int n = sc.nextInt();
        int[] weights = new int[m];
        int[] values = new int[m];

        for(int i = 0; i < m;i++) weights[i] = sc.nextInt();
        for(int i = 0; i < m;i++) values[i] = sc.nextInt();

        // dp[i,j] 表示将前 i 件物品放入容量为 j 的背包的最大价值
        // 物品从 0 开始编号
        int[][] dp = new int[m][n + 1];
        for (int i = weights[0]; i <= n; i++) {
            dp[0][i] = values[0];
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (j < weights[i]) dp[i][j] = dp[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
            }
        }
        System.out.println(dp[m - 1][n]);
    }
}
