package live.cloverescape.lc.graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author weibb
 */
public class LC785 {

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        LC785 lc785 = new LC785();
        boolean bipartite = lc785.isBipartite(graph);
        System.out.println(bipartite);
    }

    public boolean isBipartite(int[][] graph) {
        boolean res = true;
        int n = graph.length;
        int[] color = new int[n];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                queue.offer(i);
                color[i] = 1;
            }
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int[] nodes = graph[cur];
                for (int node : nodes) {
                    if (color[node] == 0) {
                        queue.offer(node);
                        color[node] = (color[cur] == 1 ? 2 : 1);
                    } else if (color[node] == color[cur]) return false;
                }
            }
        }
        return res;
    }
}
