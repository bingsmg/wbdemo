package live.clover.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author weibb
 */
public class PriorityQueueSC {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueue.offer(1);
        priorityQueue.offer(2);
        System.out.println(priorityQueue.poll());
    }
}
