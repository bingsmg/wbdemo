package live.cloverescape.lc.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weibb
 */
public class LC3148 {

    public static void main(String[] args) {
        int[][] case1 = {
                {9,5,7,3},
                {8,9,6,1},
                {6,7,14,3},
                {2,5,3,1}
        };
        int[][] case2 = {
                {4,3,2},
                {3,2,1}
        };

        System.out.println(new LC3148().maxScore(Arrays.stream(case1).map(l -> Arrays.stream(l)
                .boxed().collect(Collectors.toList())).collect(Collectors.toList())));
    }

    public int maxScore(List<List<Integer>> grid) {
        if (grid == null || grid.isEmpty()) return 0;
        int m = grid.size(), n = grid.get(0).size();
        if (n == 0) return 0;
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1 && j == n - 1) continue;
                maxScore = Math.max(maxScore, nextMax(grid, i, j));
            }
        }
        return maxScore;
    }

    private int nextMax(List<List<Integer>> grid, int x, int y) {
        int maxScore = Integer.MIN_VALUE;
        for (int i = x; i < grid.size(); i++) {
            for (int j = y; j < grid.get(0).size(); j++) {
                if (i <= x && j <= y) continue;
                maxScore = Math.max(maxScore, grid.get(i).get(j));
            }
        }
        return maxScore - grid.get(x).get(y);
    }
}
