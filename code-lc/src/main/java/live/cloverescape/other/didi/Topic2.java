package live.cloverescape.other.didi;

import java.util.ArrayList;
import java.util.List;

public class Topic2 {
    /**
     * 给定一个矩阵a[x][y], 给定一个起点s[m][n],终点x[w][q] ,求s->x的所有路线list。
     * 只能往“前”（向终点坐标的方向）运动，不能后退
     * @param args
     */
    static int x = 5, y = 5;
    static int m, n;
    static int w, q;
    static boolean left, right, up, down;
    private static final int[] dir = {0, 1, 0, -1, 0};
    public static void main(String[] args) {
        int[][] a = new int[x][y];
        int[][] t = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        // find 7 -> 24
        {
            m = 4;
            n = 4;
            w = 3;
            q = 2;
//            m = 1;
//            n = 1;
//            w = 4;
//            q = 3;
        }
        if (m < w) right = true;
        else left = true;
        if (n < q) down = true;
        else up = true;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int x = t.length, y = t[0].length;
        dfs(t, m, n, res, path);
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int[][] a, int i, int j, List<List<Integer>> res, List<Integer> path) {
        if (i < 0 || i >= x || j < 0 || j >= y) { return; }
        if (i == w && j == q) {
            path.add(a[w][q]);
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(a[i][j]);
        for (int k = 0; k < 4; k++) {
            int row = i + dir[k], col = j + dir[k + 1];
            if (left) {
                if (col > j || col < q) continue;
            }
            if (right) {
                if (col < j || col > q) continue;
            }
            if (up) {
                if (row > i || row < w) continue;
            }
            if (down) {
                if (row < i || row > w) continue;
            }
            dfs(a, row, col, res, path);
            path.remove(path.size() - 1);

        }
    }
}
