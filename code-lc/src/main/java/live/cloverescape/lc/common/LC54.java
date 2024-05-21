package live.cloverescape.lc.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weibb
 */
public class LC54 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2},
                {4, 5},
                {7, 8}
        };
        System.out.println(Arrays.toString(new LC54().traverseMatrix(matrix).toArray()));
    }

    private List<Integer> traverseMatrix(int[][] matrix) {
        int m = matrix.length, n = m == 0 ? 0 : matrix[0].length; // m=rows,n=columns
        List<Integer> res = new ArrayList<>();
        if (m == 0) return res;
        int total = m * n;
        int size = 0;
        int l = 0, r = n - 1, t = 0, b = m - 1; // left,right,top,bottom
        while (size < total) {
            if (t <= b) {
                for (int i = l; i <= r; i++) {
                    res.add(matrix[t][i]);
                    size++;
                }
                t++;
            }
            if (r >= l) {
                for (int i = t; i <= b; i++) {
                    res.add(matrix[i][r]);
                    size++;
                }
                r--;
            }
            if (t <= b) {
                for (int i = r; i >= l; i--) {
                    res.add(matrix[b][i]);
                    size++;
                }
                b--;
            }
            if (l <= r) {
                for (int i = b; i >= t; i--) {
                    res.add(matrix[i][l]);
                    size++;
                }
                l++;
            }
        }
        return res;
    }
}
