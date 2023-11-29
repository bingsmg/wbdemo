package live.cloverescape.startimes.schoolrecruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * n 数之和
 * @author weibb
 * @date 2023-11-20
 */
public class NumSum {
    public static void main(String[] args) {
        NumSum numSum = new NumSum();
        int[] nums = {2,2,2,2,2};
        int targetNum = 8;
        int n = 4;
        System.out.println(numSum.getAllSubsets(n, nums, targetNum));
    }

    public int getAllSubsets(int n, int[] nums, int targetNum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, targetNum, n, 0, new ArrayList<>(), res);
        System.out.println(Arrays.deepToString(res.toArray()));
        return res.size();
    }
    // 0,0,-1,1,2,-2
    public void backtrack(int[] nums, int targetNum, int size, int start, List<Integer> path, List<List<Integer>> res) {
        int sum = path.stream().mapToInt(Integer::intValue).sum();
        if (path.size() == size && sum == targetNum && notExists(path, res)) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, targetNum, size, i+1, path, res);
            path.remove(path.size()-1);
        }
    }

    public boolean notExists(List<Integer> path, List<List<Integer>> res) {
        for (List<Integer> list : res) {
            if (new HashSet<>(list).containsAll(path)) {
                return false;
            }
        }
        return true;
    }
}
