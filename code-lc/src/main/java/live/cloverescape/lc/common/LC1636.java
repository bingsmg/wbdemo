package live.cloverescape.lc.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 * @date 2023-11-06
 */
public class LC1636 {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] frequencySort(int[] nums) {
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        Integer[] wrappedNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // sort
        Arrays.sort(wrappedNums, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            if (freqA != freqB) {
                return freqA - freqB;
            } else {
                return b - a;
            }
        });
        return Arrays.stream(wrappedNums).mapToInt(Integer::intValue).toArray();
    }
}
