package live.clover;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weibb
 */
public class Main {

    private static Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < 10000) {
            Thread.sleep(2000);
            list.add(i);
            i+=10;
        }
    }
}