package live.cloverescape.lc.cachealgo;

import java.util.*;

/**
 * @author weibb
 */
public class AllOne {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();

        int[] nums = {-1,2,1,-4};
        allOne.threeSumClosest(nums, 1);
//        int[] nums = {};
//        allOne.inc("hello");
//        allOne.inc("hello");
//        System.out.println(allOne.getMaxKey());
//        System.out.println(allOne.getMinKey());
//        allOne.inc("leet");
//        System.out.println(allOne.getMaxKey());
//        System.out.println(allOne.getMaxKey());
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        if (n == 0) return new int[][]{newInterval};
        int s = newInterval[0], e = newInterval[1];
        if (intervals[0][0] > e) {
            res.add(newInterval);
            res.addAll(Arrays.asList(intervals));
            return res.toArray(new int[][]{});
        }
        int i = 1;
        while (i < n) {
            if (intervals[i][0] > e) {
                res.add(intervals[i]);
                continue;
            }
            if (intervals[i][1] < s) {
                res.add(intervals[i]);
            } else if (intervals[i][0] < s && intervals[i][1] > e) {
                res.add(intervals[i]);
            } else {
                int j = i + 1;
                while (j < n && intervals[j][1] < e) j++;
                res.add(new int[]{intervals[i][0], intervals[j][1]});
                i = j + 1;
            }
        }
        return res.toArray(new int[][]{});
    }

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        if (n <= 3) return Arrays.stream(nums).sum();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum > target) {
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    hi--;
                } else if (sum < target) {
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    lo++;
                } else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }

    private static class Node {
        int cnt; // 出现次数
        Node prev;
        Node next;
        Set<String> set; // 出现次数为 cnt 的字符串集合

        public Node(int cnt) {
            this.cnt = cnt;
            set = new HashSet<>();
        }
    }

    Node head; // 虚拟头 指向 minKey
    Node tail; // 虚拟尾 指向 maxKey
    Map<String, Node> map; // 具体 Node 映射

    public AllOne() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            Node nn = null; // new node
            if (node.next.cnt == node.cnt + 1) {
                nn = node.next;
            } else {
                nn = new Node(node.cnt + 1);
                node.next.prev = nn;
                nn.next = node.next;
                nn.prev = node;
                node.next = nn;
            }
            nn.set.add(key);
            map.put(key, nn);
            clear(node);
        } else {
            Node node = head.next;
            Node nn = null;
            if (node.cnt == 1) {
                nn = node;
                nn.set.add(key);
            } else {
                nn = new Node(1);
                nn.set.add(key);
                head.next.prev = nn;
                nn.next = head.next;
                nn.prev = head;
                head.next = nn;
            }
            map.put(key, nn);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        int cnt = node.cnt;
        node.set.remove(key);
        if (cnt == 1) {
            map.remove(key);
        } else {
            Node nn = null;
            if (node.prev.cnt == cnt - 1) {
                nn = node.prev;
            } else {
                nn = new Node(cnt - 1);
                nn.prev = node.prev;
                node.prev.next = nn;
                nn.next = node;
                node.prev = nn;
            }
            nn.set.add(key);
            map.put(key, nn);
        }
        clear(node);
    }

    public String getMaxKey() {
        Node node = tail.prev;
        for (String str : node.set) return str;
        return "";
    }

    public String getMinKey() {
        Node node = head.next;
        for (String str : node.set) return str;
        return "";
    }

    private void clear(Node node) {
        if (node.set.isEmpty()) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }
}
