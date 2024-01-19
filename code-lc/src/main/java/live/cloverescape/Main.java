package live.cloverescape;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 * @date 2023-11-27
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        Main main = new Main();
        Map<Integer, Integer> map = new HashMap<>();
        main.merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int i = 0, j = 0;
        int k = 0;
        while (i < m || j < n) {
            if (i == m) {
                res[k++] = nums2[j++];
            } else if (j == n) {
                res[k++] = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        for (int p = 0; p < m; p++) {
            nums1[p] = res[p];
        }

    }
}
