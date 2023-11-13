package live.cloverescape.lc.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weibb
 * @date 2023-11-02
 */
public class H406 {
    public static void main(String[] args) {
        H406 h406 = new H406();
        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };
        int[][] ans = h406.reconstructQueue(people);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] a1, int[] a2) -> {
            if (a1[0] != a2[0]) {
                return a2[0] - a1[0];
            } else {
                return a1[1] - a2[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for(int[] arr : people) {
            if (ans.size() <= arr[1]) {
                ans.add(arr);
            } else {
                ans.add(arr[1], arr);
            }
        }
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
