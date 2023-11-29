package live.cloverescape.startimes.schoolrecruit;

import java.util.HashMap;
import java.util.Map;

/**
 * 典型滑动窗口覆盖子串问题
 * @author weibb
 * @date 2023-11-21
 */
public class PasswordDecipher {
    public static void main(String[] args) {
        String str = "staaaaa";
        String secretKey = "star";
        PasswordDecipher passwordDecipher = new PasswordDecipher();
        System.out.println(passwordDecipher.decode(str, secretKey));
    }

    public String decode(String str, String secretKey) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secretKey.length(); i++) {
            char c = secretKey.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        int r = -1;
        int l = 0;
        Map<Character, Integer> tmp = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        int leftIdx = -1, rightIdx = -1;

        while (++r < arr.length) {
            char c = arr[r];
            tmp.merge(c, 1, Integer::sum);
            while (check(map, tmp) && l <= r) {
                if (r - l + 1 < ans) {
                    ans = r - l + 1;
                    leftIdx = l;
                    rightIdx = r;
                }
                if (tmp.containsKey(arr[l])) {
                    tmp.merge(arr[l], -1, Integer::sum);
                }
                l++;
            }
        }
        if (leftIdx == -1) {
            return "invalid key";
        }
        StringBuilder sb = new StringBuilder();
        String res = new String(arr, leftIdx, rightIdx - leftIdx + 1);
        for (int i = 0; i < res.length(); i++) {
            if (map.containsKey(res.charAt(i))) {
                continue;
            }
            sb.append(res.charAt(i));
        }
        return new String(sb);
    }

    private boolean check(Map<Character, Integer> map, Map<Character, Integer> tmp) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (!tmp.containsKey(entry.getKey()) || tmp.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}