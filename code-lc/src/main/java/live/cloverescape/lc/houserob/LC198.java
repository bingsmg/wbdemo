package live.cloverescape.lc.houserob;

/**
 * @author weibb
 * @date 2023-11-07
 */
public class LC198 {
    public static void main(String[] args) {
        LC198 lc198 = new LC198();
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(lc198.rob(nums));
    }

    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        int ans = 0;
        int[] dp = new int[nums.length + 2];
        for (int i = 2; i < nums.length + 2; i++) {
            ans = Math.max(a + nums[i-2], b);
            a = b;
            b = ans;
        }
        return ans;
    }
}
