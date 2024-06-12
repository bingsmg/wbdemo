package live.clover.threadcomm.e1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weibb
 */
public class MyList {

    // volatile 保证 A 线程和 B 线程间的可视性
    volatile private List<String> list = new ArrayList<>();

    public void add() {
        list.add("list");
    }

    public int size() {
        return list.size();
    }
}
