package live.cloverescape.startimes.schoolrecruit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class Main {
    public static void main(String[] args) throws IOException {
        Main replaceRuleTemplate = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String template = br.readLine();
        String infos = br.readLine();
        System.out.println(replaceRuleTemplate.process(template, infos));
    }

    public String process(String template, String infos) {
        Map<String, String> map = processStr(infos);
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

    public Map<String, String> processStr(String infos) {
        String[] split = infos.split(";");
        Map<String, String> map = new HashMap<>(10);
        if (split.length == 1 && Objects.equals(split[0], "")) {
            return map;
        }
        for (String s : split) {
            String[] kv = s.split(",");
            map.put(kv[0], kv[1]);
        }
        return map;
    }
}
