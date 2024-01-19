package live.cloverescape.lc.jumpgame;

/**
 * @author weibb
 * @date 2024-01-10
 */
public class LC55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cover < i) return false;
            // dp [i] 记录 nums [i] 之前所能到达的最远距离
            cover = Math.max(cover, i + nums[i]);
        }
        return true;
    }
}
