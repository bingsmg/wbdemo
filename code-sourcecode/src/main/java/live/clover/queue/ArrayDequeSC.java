package live.clover.queue;

import java.util.ArrayDeque;

/**
 * @author weibb
 */
public class ArrayDequeSC {
    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < 17; i++) {
            arrayDeque.push(i);
        }
        for (Integer i : arrayDeque) {
            System.out.print(i + "->");
        }
        System.out.println();
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.pop());
        System.out.println(arrayDeque.peek());
    }
}
