package live.cloverescape.startimes.schoolrecruit;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author weibb
 * @date 2023-11-20
 */
public class BackToTextString {
    public static void main(String[] args) throws IOException {
        BackToTextString backToTextString = new BackToTextString();
        List<ReadFile.Record> records = ReadFile.readFile(ReadFile.filePath);
        for (ReadFile.Record record : records) {
            System.out.println(backToTextString.judgeBackString(record.str, record.k) ? "YES" : "NO");
        }
    }

    public boolean judgeBackString(String s, int k) {
        Map<Character, Integer> map = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, v -> 1, Integer::sum));
        // 出现奇数次数的字符个数
        int oddNums = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & 1) == 1) {
                oddNums++;
            }
        }
        if (oddNums <= 1) {
            return true;
        }
        if (oddNums >= k) {
            return oddNums - k <= 1;
        } else {
            return k - oddNums == 1 || ((k - oddNums) & 1) == 0;
        }
    }
}
