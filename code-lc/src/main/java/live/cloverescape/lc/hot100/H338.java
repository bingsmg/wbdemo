package live.cloverescape.lc.hot100;

import java.util.Arrays;

/**
 * @author weibb
 * @date 2023-11-06
 */
public class H338 {
    public static void main(String[] args) {
        H338 h338 = new H338();
        System.out.println(Arrays.toString(h338.countBits(5)));
    }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (1 & i);
        }
        return ans;
    }
}
