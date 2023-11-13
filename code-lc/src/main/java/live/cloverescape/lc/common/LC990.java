package live.cloverescape.lc.common;

/**
 * @author weibb
 * @date 2023-11-03
 */
public class LC990 {
    public static void main(String[] args) {
        LC990 lc990 = new LC990();
        String[] equations = new String[] {
                "a==b",
                "b!=a"
        };
        System.out.println(lc990.equationsPossible(equations));
    }

    private final int[] parent = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int id1 = equation.charAt(0) - 'a';
                int id2 = equation.charAt(3) - 'a';
                union(id1, id2);
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int id1 = find(equation.charAt(0) - 'a');
                int id2 = find(equation.charAt(3) - 'a');
                if (id2 == id1) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int id1, int id2) {
        parent[find(id1)] = find(id2);
    }

    public int find(int id) {
        while (id != parent[id]) {
            parent[id] = parent[parent[id]];
            id = parent[id];
        }
        return id;
    }
}
