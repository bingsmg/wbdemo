package live.clover;

import java.util.ArrayList;

/**
 * x 表示未知或未定义的值，JVM 参数里，参数值可以是任何类型的值，所以用 X
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author weibb
 * @date 2023-12-08
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
