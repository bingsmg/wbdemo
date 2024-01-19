package live.cloverescape.lc.common;

/**
 * @author weibb
 */
public class LC134 {

    public static void main(String[] args) {
        // [1,2,3,4,5], cost = [3,4,5,1,2]
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};
        System.out.println(new LC134().canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = cost.length;
        for (int i = 0; i < n; ) {
            // 剩余油量
            int rest = gas[i] - cost[i];
            if (rest < 0) {
                i++;
            } else {
                // 当前位置
                int p = i + 1;
                while (p % n != i) {
                    rest += gas[p % n] - cost[p % n];
                    if (rest < 0) {
                        break;
                    }
                    p++;
                }
                if (p % n == i) return i;
                else i = p;
            }
        }
        return -1;
    }
}
