package live.clover.list;

import java.util.ArrayList;

/**
 * ArrayList source code analyze
 * @author weibb
 */
public class ArrayListSC {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        Object o = arrayList.get(1);
        arrayList.remove(1);
        arrayList.remove(Integer.valueOf(2));
        arrayList.add(5, 11);
        arrayList.set(5, 12);
        arrayList.subList(0, 3);
        arrayList.indexOf(2);
    }
}
