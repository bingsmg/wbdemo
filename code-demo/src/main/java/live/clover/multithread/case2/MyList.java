package live.clover.multithread.case2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weibb
 * @date 2023-08-30
 */
public class MyList {
    private static List list = new ArrayList<>();

    public static void add() {
        list.add("anyString");
    }

    public static int size() {
        return list.size();
    }
}
