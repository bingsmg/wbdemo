package live.cloverescape;

import java.util.*;

/**
 * @author weibb
 * @date 2023-11-27
 */
public class Main {
    public static void main(String[] args) {
        char c = 'b';
        System.out.println(c);
        c -= 1;
        System.out.println(c);
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