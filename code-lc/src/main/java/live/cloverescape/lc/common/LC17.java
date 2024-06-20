package live.cloverescape.lc.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weibb
 */
public class LC17 {
    public static void main(String[] args) {
        new LC17().letterCombinations("23").forEach(System.out::println);
    }


    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        List<String> res = new ArrayList<>();
        StringBuilder comb = new StringBuilder();
        backtrack(map, res, digits, 0, comb);
        return res;
    }

    private void backtrack(Map<Character, String> map, List<String> res, String digits, int pos, StringBuilder comb) {
        if (comb.length() == digits.length()) {
            res.add(comb.toString());
            return;
        } else {
            char c = digits.charAt(pos);
            String cs = map.get(c);
            for (int i = 0; i < cs.length(); i++) {
                comb.append(cs.charAt(i));
                backtrack(map, res, digits, pos + 1, comb);
                comb.deleteCharAt(comb.length() - 1);
            }
        }
    }
}
