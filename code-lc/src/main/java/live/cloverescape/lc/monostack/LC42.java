package live.cloverescape.lc.monostack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weibb
 * @date 2023-11-28
 */
public class LC42 {
    public static void main(String[] args) {
        LC42 lc42 = new LC42();
        System.out.println(lc42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    // 单调栈是以宽度来计算的
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[i]);
                ans += distance * (min - h);
            }
            stack.push(i);
        }
        return ans;
    }
}
