package live.cloverescape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weibb
 * @date 2023-11-27
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        for (List<Integer> integers : main.combinationSum2(candidates, 8)) {
            System.out.println(Arrays.toString(integers.toArray()));
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, path, candidates, target, 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> path, int[] candidates,
                           int target, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target - candidates[i] < 0) break;
            if (i > 0 && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backtrack(ans, path, candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}