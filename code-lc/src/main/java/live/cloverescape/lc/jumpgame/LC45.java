package live.cloverescape.lc.jumpgame;

/**
 * @author weibb
 * @date 2024-01-10
 */
public class LC45 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        LC45 lc45 = new LC45();
        System.out.println(lc45.jump(nums));
    }
    //[2,3,1,1,4]
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int cover = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (i == end) {
                end = cover;
                ans++;
            }
        }
        return ans;
    }
}
