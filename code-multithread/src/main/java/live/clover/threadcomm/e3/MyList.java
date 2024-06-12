package live.clover.threadcomm.e3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weibb
 */
public class MyList {

    private static List<Object> list = new ArrayList<>();

    public static void add() { list.add("anyString"); }

    public static int size() { return list.size(); }
}
