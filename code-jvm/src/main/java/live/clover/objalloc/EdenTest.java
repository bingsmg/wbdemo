package live.clover.objalloc;

/**
 * @author weibb
 */
public class EdenTest {

    private static final int _1MB = 1024 * 1024; // 2^20Byte = 1MB

    public static void main(String[] args) {
        EdenTest.testAllocation();
    }

    /**
     * 因为 JDK11 默认是 G1，分析并不简单，可以使用 :-XX:+UseSerialGC
     * 使用 serial+serial old 组合，其次参数 -XX:+PrintGCDetails 也废弃了
     * 推荐使用 -Xlog:gc* 参数
     * -verbose:gc -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -Xlog:gc*
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[3 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
