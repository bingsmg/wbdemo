package live.cloverescape.startimes;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author weibb
 */
public class PasswordCheck {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>() {
            {
                put("Abcdefg1$", 0);
                put("", 8);
                put("Abc1$", 3);
                put("Abcdefghijklmnopqrstu1$", 3);
                put("Abcdefg123", 1);
                put("Abcdefg$!@", 1);
                put("123456$!@", 1);
                put("aaabb123$!@", 1);
                put("123456", 2);
                put("abcdefg", 2);
                put("@#%&*#^%$", 2);
                put("12a", 5);
                put("1234567890abcdefghij224", 5);
                put("12@", 5);
                put("1234567890@#%&*#^%$@223", 5);
                put("ab@", 5);
                put("abcdefghij@@klmnopqrstu", 5);
                put("aaabb", 3);
                put("abcdefghij@@@1234567890", 3);
                put("abcdefghij@@@ab", 1);
                put("aaab@", 3);
                put("aaaabb", 2);
                put("aaaaab7!", 2);
            }
        };
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println("test case size: " + entries.size());
        int passCnt = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            boolean passFlag;
//            System.out.println(entry.getKey() + "====" + (passFlag = (updateStrongPwd(entry.getKey()) == entry.getValue())));
            System.out.println(entry.getKey() + "====" + (passFlag = (strongPasswordChecker(entry.getKey()) == entry.getValue())));
            if (passFlag) passCnt++;
        }
        System.out.println("pass count is: " + passCnt);
    }

    public static int updateStrongPwd(String pwd) {
        int ans = 0;
        char[] cs = pwd.toCharArray();
        int n = pwd.length();
        int continuousCnt = 0; // 不同连续字符组计数
        int i = 0;
        boolean hasDigit = false, hasChar = false, hasSpecial = false;
        while (i < cs.length) {
            char c = cs[i];
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLowerCase(c) || Character.isUpperCase(c)) {
                hasChar = true;
            } else {
                hasSpecial = true;
            }
            int j = i + 1, cnt = 1;
            while (j < cs.length - 1 && c == cs[j]) {
                cnt++;
                if (cnt >= 3) {
                    continuousCnt++;
                }
                j++;
            }
            i = j;
        }
        int missCharTypeCnt = 0; // 缺失种类数计数
        if (!hasDigit) missCharTypeCnt++;
        if (!hasChar) missCharTypeCnt++;
        if (!hasSpecial) missCharTypeCnt++;

        if (n < 8) {
            int missChar = 8 - n;
            return 0;
        } else if (n > 20) {
            continuousCnt += n - 20;
        } else {

        }
        return continuousCnt;
    }

    public static int strongPasswordChecker(String s) {
        int res = 0, i = 0;
        int duplicateCount = 0;
        int[] typeCount = new int[3];
        int[] bucket = new int[3];
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) typeCount[0] = 1;
            if (Character.isUpperCase(c)) typeCount[1] = 1;
            if (Character.isDigit(c)) typeCount[2] = 1;

            int j = i;
            while (i < s.length() && s.charAt(i)==c) {
                i++;
            }
            int segmentLength = i - j;
            if (segmentLength >= 3) {
                duplicateCount += segmentLength / 3;
                bucket[segmentLength % 3]++;
            }
        }

        int missingTypeCount = 3 - (typeCount[0] + typeCount[1] + typeCount[2]);

        if (s.length() < 6) {
            return Math.max(missingTypeCount, 6 - s.length());
        } else if (s.length() <= 20) {
            return Math.max(missingTypeCount, duplicateCount);
        } else {
            int overLength = s.length() - 20;
            res = overLength;
            if (overLength <= duplicateCount * 3) {
                duplicateCount -= overLength / 3;
                if (overLength % 3 == 1 && bucket[0] > 0) duplicateCount--;
                if (overLength % 3 == 2) {
                    if (bucket[0] > 0) duplicateCount--;
                    else if (bucket[1] > 1) {duplicateCount -= 2;}
                }
            } else {
                duplicateCount = 0;
            }
            return res + Math.max(missingTypeCount, duplicateCount);
        }
    }
}
