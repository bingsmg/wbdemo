package live.cloverescape.startimes;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weibb
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int[][] grid = {
                {0, 1, 0},
                {0, 0 ,0},
                {0, 0, 1}
        };
        System.out.println(main.shortestBridge(grid));
    }

    private static final int[] directions = {-1, 0, 1, 0, -1};
    private static final Deque<int[]> queue = new ArrayDeque<>();

    public int shortestBridge(int[][] grid) {
        queue.clear();
        int m = grid.length, n = (m == 0 ? 0 : grid[0].length);
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (flag) break;
            for (int j = 0; j < n; j++) {
                if (!flag && grid[i][j] == 1) {
                    dfs(grid, i, j, m, n);
                    flag = true;
                }
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size-- > 0) {
                int[] point = queue.pollFirst();
                for (int i = 0; i < 4; i++) {
                    int x = point[0] + directions[i];
                    int y = point[1] + directions[i + 1];
                    if (x < 0 || x == m || y < 0 || y == m || grid[x][y] == 2) continue;
                    if (grid[x][y] == 1) {
                        return level;
                    }
                    queue.push(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
        }
        return level;
    }

    private void dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i == m || j < 0 || j == n || grid[i][j] == 2) return;
        if (grid[i][j] == 0) {
            queue.offerLast(new int[]{i, j});
            return;
        }
        grid[i][j] = 2;
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i, j - 1, m, n);
    }
}
