package live.cloverescape.ali;

import java.util.*;

/**
 * @author weibb
 */
public class Topic1 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 3, 5, 5, 6, 6, 7, 8, 9, 9};
        int m = 3;
        Topic1 topic1 = new Topic1();
        topic1.solution(nums, m);
    }

    private void solution(int[] nums, int m) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(m, (a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() == m && entry.getValue() > Objects.requireNonNull(minHeap.peek()).getValue()) {
                minHeap.offer(entry);
                minHeap.poll();
            } else {
                minHeap.offer(entry);
            }
        }
        for (int i = 0; i < m; i++) {
            res.add(Objects.requireNonNull(minHeap.poll()).getKey());
        }
        res.forEach(System.out::print);
    }
}
