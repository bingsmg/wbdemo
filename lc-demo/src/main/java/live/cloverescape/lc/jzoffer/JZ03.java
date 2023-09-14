package live.cloverescape.lc.jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author seven
 */
public class JZ03 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber2(nums));
    }
    // 该实现方式用了 map 记录每一个元素出现的次数实现，但是审题发现可能不是最优方案，因为忽略了数组里的 n 个元素是 0-n-1 的
    // 那如何利用该条件呢? 一定要知道索引和值是一对多关系
    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> numToCntMap = new HashMap<>();
        for (int num : nums) {
            numToCntMap.put(num, numToCntMap.getOrDefault(num, 0) + 1);
            if (numToCntMap.get(num) > 1) {
                return num;
            }
        }
        return -1;
    }
    // 岗位和人才分配的例子好使，永远将当前人才放到对应的岗位，如果对应岗位已经有人则人才溢出，否则交换往前继续遍历，理想情况，总会把相应的人才分配到相应的岗位（总会交换到合适位置，不用担心目前只交换对了一个 ）
    // 如果发现人才溢出，就会在后续的分配过程中出现原岗位人才和正在分配的人才冲突的问题。
    public static int findRepeatNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
