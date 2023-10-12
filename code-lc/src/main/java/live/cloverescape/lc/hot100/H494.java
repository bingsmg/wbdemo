package live.cloverescape.lc.hot100;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class H494 {
    int ans = 0;
    int[] arr = new int[]{-1, 1};

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int target = 1;

        H494 h494 = new H494();
        System.out.println(h494.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return ans;
    }

    private void backtrack(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            if (sum == target) {
                ans ++;
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            int value = nums[idx] * arr[i];
            sum += value;
            backtrack(nums, target, idx + 1, sum);
            sum -= value;
        }
    }

}
