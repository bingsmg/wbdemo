package live.cloverescape.lc.lc101;

import java.util.Arrays;

/**
 * @author weibb
 */
public class LC300 {

    public static void main(String[] args) {
        LC300 lc300 = new LC300();
        int[] input = {1,3,6,7,9,4,10,5,6};
        System.out.println(lc300.lengthOfLIS(input));
        System.out.println(lc300.lengthOfLISForBinary(input));
    }

    public int lengthOfLIS(int[] nums) { // [10,9,2,5,3,7,101,18] [2,3,7,101]
        // 最长严格递增子序列的长度
        int n = nums.length;
        int[] dp = new int[n]; // dp[i] 表示以 i 结尾的子序列的最长递增长度
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        return dp[n - 1];
    }

    private int lengthOfLISForBinary(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) return 0;
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) d[++len] = nums[i];
            else if (nums[i] == d[len]) continue;
            else {
                int lo = 1, hi = len, pos = 0;
                while (lo <= hi) {
                    int mid = lo + ((hi - lo) >> 1);
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
