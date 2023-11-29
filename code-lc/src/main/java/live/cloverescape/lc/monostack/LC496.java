package live.cloverescape.lc.monostack;

import java.util.*;

/**
 * @author weibb
 * @date 2023-11-28
 */
public class LC496 {
    public static void main(String[] args) {
        LC496 lc496 = new LC496();
        System.out.println(Arrays.toString(lc496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextMaxNums = new int[nums2.length];
        Arrays.fill(nextMaxNums, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nextMaxNums[stack.peek()] = nums2[i];
                stack.pop();
            }
            stack.push(i);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] =  nextMaxNums[map.get(nums1[i])];
        }
        return ans;
    }
}
