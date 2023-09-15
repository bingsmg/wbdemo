package live.cloverescape.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author seven
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(solution.coinChange(coins, amount));
    }
}

class Solution {

    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        return dfs(coins, amount);
    }
    // 返回 amount 金额需要的最少次数
    private Integer dfs(int[] coins, int amount) {
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int minNumber = 0x7fffffff;
        for (int coin : coins) {
            minNumber = Math.min(minNumber, dfs(coins, amount - coin)) + 1;
        }
        map.put(amount, minNumber);
        return minNumber;
    }
}