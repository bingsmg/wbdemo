package live.cloverescape.lc.common;

/**
 * @author weibb
 */
public class LC79 {
    private int[] dir = {-1, 0, 1, 0, -1};

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(new LC79().exist(board, word));
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = m == 0 ? 0 : board[0].length;
        if (m == 0) return false;
        boolean ans = false;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(i, j, board, word, ans, visited, 0);
            }
        }
        return ans;
    }

    private void backtrack(int i, int j, char[][] board, String word, boolean ans, boolean[][] visited, int idx) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (visited[i][j] || ans || board[i][j] != word.charAt(idx)) return;
        if (idx == word.length() - 1) {
            ans = true;
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int x = i + dir[k], y = j + dir[k+1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                backtrack(x, y, board, word, ans, visited, idx + 1);
            }
        }
        visited[i][j] = false;
    }
}
