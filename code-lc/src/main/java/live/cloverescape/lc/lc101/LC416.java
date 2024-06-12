package live.cloverescape.lc.lc101;

import java.util.Arrays;

/**
 * @author weibb
 */
public class LC416 {
    public static void main(String[] args) {
        System.out.println(new LC416().canPartition(new int[]{1,5,10,6}));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        int target = sum / 2, n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1]; // dp[i][j] 表示从前 i 个数字中选择是否 和能得到 j
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}
