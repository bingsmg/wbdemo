package live.cloverescape.lc.graph;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author weibb
 */
public class LC207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] colors = new int[numCourses];
        Arrays.sort(prerequisites, (a, b) -> a[1] - b[1]);
        for (int[] prerequisite : prerequisites) {
            colors[prerequisite[0]] = 1; // 染色 1
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (colors[i] == 1) queue.add(i);
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[0] == course) {
                    if (colors[prerequisite[1]] == 0) {
                        if (colors[course] == 1) {
                            colors[prerequisite[1]] = 2;
                        } else {
                            colors[prerequisite[1]] = 1;
                        }
                        queue.offer(prerequisite[1]);
                    } else {
                        if (colors[prerequisite[1]] == colors[course]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
