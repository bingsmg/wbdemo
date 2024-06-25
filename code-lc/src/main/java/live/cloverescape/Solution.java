package live.cloverescape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weibb
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 1, 1, 10, 10, 10};
        int[] arr3 = {0, 0, 1, 2, 3, 3, 4, 7, 7, 8};
        Solution solution = new Solution();
        List<Integer> elements = solution.findClosestElements(arr1, 4, 3);
        List<Integer> elements1 = solution.findClosestElements(arr1, 4, -1);
        List<Integer> elements2 = solution.findClosestElements(arr2, 1, 9);
        List<Integer> elements3 = solution.findClosestElements(arr3, 4, 3);
        System.out.println();
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int n = (arr == null ? 0 : arr.length);
        if (n == 0) return res;
        int lo = 0, hi = n, mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (arr[mid] < x) lo = mid + 1;
            else if (arr[mid] > x) hi = mid;
            else if (arr[mid] == x) hi = mid;
        }
        int idx = -1;
        // 寻找最接近 x 的第一个点
        if (hi == n) idx = n - 1;
        else if (hi == 0) idx = 0;
        else idx = (arr[hi] - x) > (arr[hi - 1] - x) ? (hi - 1) : hi;
        lo = idx - 1;
        hi = idx + 1;
        // 优化，循环只查找出 [lo,hi] 区间即可，最后 res 按顺序添加索引元素，免去排序过程，降低时间复杂度
        while (hi - lo - 1 < k) {
            if (lo >= 0 && hi < n) {
                if (Math.abs(arr[hi] - x) >= Math.abs(arr[lo] - x)) lo--;
                else hi++;
            }
            else if (lo >= 0) lo--;
            else  hi++;
        }
        for (int i = lo + 1; i <= hi - 1; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
