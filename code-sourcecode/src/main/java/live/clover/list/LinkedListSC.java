package live.clover.list;

import java.util.LinkedList;

/**
 * ArrayList source code analyze
 * @author weibb
 */
public class LinkedListSC {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            linkedList.add(i);
        }
        Object o = linkedList.get(1);
        linkedList.remove(1);
        linkedList.remove(Integer.valueOf(2));
        linkedList.add(5, 11);
        linkedList.set(5, 12);
        linkedList.subList(0, 3);
        linkedList.indexOf(2);
    }
}
