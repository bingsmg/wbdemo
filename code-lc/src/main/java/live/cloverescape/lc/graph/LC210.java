package live.cloverescape.lc.graph;

import java.util.*;

/**
 * @author weibb
 */
public class LC210 {

    public static void main(String[] args) {
        LC210 lc210 = new LC210();
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        int[] order = lc210.findOrder(numCourses, prerequisites);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return new int[0];

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
            indegree[prerequisite[0]]++;
        }
        // 入度为 0 的节点作为待处理先入队，每一次都删除入度为 0 的节点，更新其他节点的入度。
        // 所以提前记录每个节点对应的后继列表，在删除度为 0 的过程中更新(递减)它后继点的入度，
        // 如果后继入度删除完已经为 0，则把它入队，然后删除它，处理它后继列表的入度，循环往复
        // 最后如果没有环的话，则所有节点的入度为 0
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int head = queue.poll();
            res.add(head);
            ArrayList<Integer> succ = graph[head]; // successors
            for (Integer nextCourse : succ) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) queue.offer(nextCourse);
            }
        }
        for (int i : indegree) {
            if (i != 0) return new int[0];
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
