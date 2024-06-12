package live.cloverescape;

import java.util.*;

/**
 * @author weibb
 * @date 2023-11-27
 */
public class Main {
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println("System properties: ###################");
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey().toString() + ": " + entry.getValue().toString());
        }
        System.out.println("\n\n\nEnvironment variables: ####################");
        Map<String, String> envs = System.getenv();
        for (Map.Entry<String, String> entry : envs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
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