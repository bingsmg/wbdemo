package live.cloverescape.lc.houserob;

/**
 * @author weibb
 * @date 2023-11-07
 */
public class LC213 {
    public static void main(String[] args) {
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int v1 = 0;
        int v2 = 0;
        int ans = 0;
        for (int i = start; i <= end; i++) {
            ans = Math.max(v2, v1 + nums[i]);
            v1 = v2;
            v2 = ans;
        }
        return ans;
    }
}
