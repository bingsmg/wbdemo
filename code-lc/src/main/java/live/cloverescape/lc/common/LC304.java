package live.cloverescape.lc.common;

/**
 * @author weibb
 */
public class LC304 {
    class NumMatrix {

        private int[][] mat;
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            mat = matrix;
            int m = mat.length, n = mat[0].length;
            preSum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + mat[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSum[row2][col2] - preSum[row1][col1 - 1] - preSum[row1 - 1][col2] + preSum[row1 - 1][col1 - 1];
        }
    }
}
