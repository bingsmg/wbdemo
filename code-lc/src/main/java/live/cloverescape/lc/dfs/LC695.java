package live.cloverescape.lc.dfs;

/**
 * @author weibb
 */
public class LC695 {

    private final int[] directions = {-1, 0, 1, 0, -1};
    private int m;
    private int n;

    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, int i, int j) {
        grid[i][j] = 0;
        int area = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + directions[k], y = j + directions[k + 1];
            if (x < 0 || x >= m || y < 0 || y >= n) continue;
            if (grid[x][y] == 0) continue;
            area += dfs(grid, x, y);
        }
        return area;
    }

//    private int dfs(int[][] grid, int i, int j) {
//        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
//        if (grid[i][j] == 0) return 0;
//        // 遍历完记录状态
//        grid[i][j] = 0;
//        // 上右下左
//        return 1 + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1);
//    }

    public static void main(String[] args) {
        LC695 lc695 = new LC695();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(lc695.maxAreaOfIsland(grid));
    }
}
