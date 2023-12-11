package live.clover;

import org.openjdk.jol.info.ClassLayout;

import java.util.HashMap;

/**
 * @author weibb
 * @date 2023-12-08
 */
public class ObjectSizeAnalysis {

    static class ResultMap extends HashMap {}

    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        ResultMap resultMap = new ResultMap();
        resultMap.put("id", 1L);
        resultMap.put("companyId", 2L);
        resultMap.put("customId", 34554L);
        resultMap.put("custName", "fdfdfdfdf");
        resultMap.put("custMobile", "1231131321313213");
        resultMap.put("hhhh", 324324L);

        Object o = new Object();
        ClassLayout classLayout = ClassLayout.parseInstance(o);
        System.out.println(classLayout.toPrintable());

    }
}
