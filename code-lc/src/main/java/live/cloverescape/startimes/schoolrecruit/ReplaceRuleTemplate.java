package live.cloverescape.startimes.schoolrecruit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author weibb
 * @date 2023-11-20
 */
public class ReplaceRuleTemplate {
    public static void main(String[] args) {
        ReplaceRuleTemplate replaceRuleTemplate = new ReplaceRuleTemplate();
        String template = "Hello {name}, your order {orderID} has been shipped. " +
                "The tracking number is {trackingNumber}. {orderID} has been shipped again. The new tracking number is {trackingNumber}.";
        String[][] strings = new String[][] {
            {"name", "Alice"},
            {"orderID", "123"},
            {"orderID", "987654"},
            {"trackingNumber", "WXYZ789"}
        };
        List<List<String>> infos = Arrays.stream(strings).map(info -> Arrays.stream(info).collect(Collectors.toList())).collect(Collectors.toList());
        // 结果：Hello Alice, your order 987654 has been shipped. The tracking number is WXYZ789. 987654 has been shipped again. The new tracking number is WXYZ789.
        System.out.println(replaceRuleTemplate.evaluate(template, infos));
    }

    /**
     * 计算替换后的消息模版
     * @param template 消息模版
     * @param infos 规则列表
     * @return 替换后的模版
     */
    public String evaluate(String template, List<List<String>> infos) {
        Map<String, String> map = infos.stream()
                .collect(Collectors.toMap(info -> info.get(0), info -> info.get(1), (o, n) -> n));
        StringBuilder ans = new StringBuilder();
        char[] carr = template.toCharArray();

        for (int i = 0; i < carr.length; i++) {
            if (carr[i] != '{') {
                ans.append(carr[i]);
                continue;
            }
            int start = i;
            while (carr[start] != '}') {
                start++;
            }
            String key = new String(carr, i+1, start-i-1);
            ans.append(map.getOrDefault(key, "?"));
            i = start;
        }
        return ans.toString();
    }
}
