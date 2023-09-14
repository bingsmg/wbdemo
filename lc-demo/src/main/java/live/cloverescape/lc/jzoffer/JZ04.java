package live.cloverescape.lc.jzoffer;

/**
 * @author seven
 */
public class JZ04 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(matrix, 90));
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int i = rows-1, j = 0;
        while (i < rows && j < columns) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
