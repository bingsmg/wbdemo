package live.cloverescape.lc.monostack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author weibb
 * @date 2023-11-28
 */
public class LC739 {

    public static void main(String[] args) {
        LC739 lc739 = new LC739();
        System.out.println(Arrays.toString(lc739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (temperatures[stack.peek()] > temperatures[i]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                        Integer idx = stack.peek();
                        res[idx] = i - idx;
                        stack.pop();
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }
}
