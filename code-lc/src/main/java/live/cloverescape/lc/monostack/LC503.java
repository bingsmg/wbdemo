package live.cloverescape.lc.monostack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author weibb
 * @date 2023-11-28
 */
public class LC503 {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        int i = 0, loop = 0;
        while (i < n && loop < 2) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ans[stack.peek()] = nums[i];
                stack.pop();
            }
            if (loop == 0) {
                stack.push(i);
            }
            i++;
            if (i == n) {
                loop++;
                i = 0;
            }
        }
        return ans;
    }
    // 1 2 3 4 5
    // 5 4 3 2 1
    // 9 1 8 7 4
    // 1 9 8 7 4
    // 1 2 1
}
