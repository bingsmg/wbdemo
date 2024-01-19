package live.clover.oom;

import java.util.ArrayList;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 设置为一样避免堆自动扩展
 * @author weibb
 */
public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {
        ArrayList<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
