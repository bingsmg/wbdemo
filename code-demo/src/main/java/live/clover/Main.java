package live.clover;

import java.util.*;

/**
 * @author weibb
 * @date 2023-08-23
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

    int total;
    int res = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        List<Integer> path = new ArrayList<>();
        dfs(coins, amount, path);
        return res;
    }

    private void dfs(int[] coins, int amount, List<Integer> path) {
        if (total == amount) {
            res = Math.min(path.size(), res);
            return;
        }
        if (map.containsKey(total)) {
            return ;
        }

        map.put(total, Math.min(path.size(), map.getOrDefault(total, Integer.MAX_VALUE)));

        for (int coin : coins) {
            if (total + coin > amount) {
                break;
            }
            total += coin;
            path.add(coin);
            dfs(coins, amount, path);
            total -= coin;
            path.remove(path.size() - 1);
        }
    }
}





