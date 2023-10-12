package live.cloverescape.lc.hot100;

import java.util.Arrays;
import java.util.List;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class H581 {
    public static void main(String[] args) {
        H581 h581 = new H581();
        List<Integer[]> demos = (List<Integer[]>) Arrays.asList(
                new Integer[]{2,6,4,8,10,9,15},
                new Integer[]{1,2,3,4},
                new Integer[]{1});
        for (Integer[] demo : demos) {
            int[] array = Arrays.stream(demo).mapToInt(Integer::intValue).toArray();
            System.out.println(h581.findUnsortedSubarray(array));
            System.out.println(h581.findUnsortedSubarrayTwoPoint(array));
            System.out.println("------------------------");
        }
    }

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] numsCopy = Arrays.stream(nums).sorted().toArray();

        int l = 0, r = nums.length - 1;
        while (l <= r && numsCopy[l] == nums[l]) {
            l++;
        }
        while (r >= 0 && numsCopy[r] == nums[r]) {
            r--;
        }
        return Math.max(r - l + 1, 0);
    }

    /**
     * 我提供一个我的理解（有点贪心的感觉）：
     * 首先，我们希望这个数组是单调递增的（不是严格单调递增，相邻可以相等）
     * 从左往右，一开始 max 是第一个数。如果数组符合要求，那么遍历的每一个数都只会相等或者越来越大，也就是我们只会不停地更新 max 的值。
     * 但是，一旦碰到一个小于 max 的数，就说明这个数字的位置不对，这个数字一定是在我们最终要重新 sort 的 subarray 里的，并且是右边界（因为我们在不断向右探索）。
     * 从右往左同理，只是大小关系反一反，我们能找到需要重新 sort 的 subarray 的左边界。
     * 这样就找到答案了。
     *
     * @param nums 数组
     * @return 最短无序连续子数组长度
     */
    public int findUnsortedSubarrayTwoPoint(int[] nums) {
        int ans = 0;
        int n = nums.length;

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }

            if (nums[n-1-i] > min) {
                l = n-1-i;
            } else {
                min = nums[n - 1 - i];
            }
        }
        return r == -1 ? 0 : r-l+1;
    }
}
