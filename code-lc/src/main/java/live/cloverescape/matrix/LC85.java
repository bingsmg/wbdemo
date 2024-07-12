package live.cloverescape.matrix;

/**
 * @author weibb
 */
public class LC85 {

    public static void main(String[] args) {
        LC85 lc85 = new LC85();
        char[][] matrix = {
                {'1','0','1','1','1'},
                {'0','1','0','1','0'},
                {'1','1','0','1','1'},
                {'1','1','0','1','1'},
                {'0','1','1','1','1'}
        };
        System.out.println(lc85.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int m = (matrix == null ? 0 : matrix.length), n = (m == 0 ? 0 : matrix[0].length);
        if (m == 0 || n == 0) return -1;
        // left[i][j] 表示以 matrix[i][j] 为矩阵右下角的左侧连续 1 的个数
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    left[i][j] = (matrix[i][j] == '1' ? 1 : 0);
                    continue;
                }
                if (matrix[i][j] == '1') left[i][j] = left[i][j - 1] + 1;
                else left[i][j] = 0;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (left[i][j] == 0) continue;
                int width = left[i][j], height = 1, area = left[i][j];
                for (int k = i - 1; k >= 0; k--) {
                    if (left[k][j] == 0) break;
                    width = Math.min(width, left[k][j]);
                    height = i - k + 1;
                    area = Math.max(area, width * height);
                }
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
