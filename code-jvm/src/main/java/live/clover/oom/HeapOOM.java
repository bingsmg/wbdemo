package live.clover.oom;

import java.util.ArrayList;

/**
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 该 demo 创建强引用，由于是强引用，在主线程运行结束前，GC自然不会回收，一直到内存溢出。<br>
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
