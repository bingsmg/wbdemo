package live.cloverescape.lc.hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author weibb
 * @date 2023-10-13
 */
public class H448 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        H448 h448 = new H448();
        System.out.println(h448.findDisappearedNumbers(nums));
//        System.out.println(h448.hashEnum(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = (nums[i] - 1) % nums.length;
            nums[idx] = nums[idx] + nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= nums.length) {
                res.add(i+1);
            }
        }
        return res;
    }

    private List<Integer> hashEnum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(i+1);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return new ArrayList<>(set);
    }
}
