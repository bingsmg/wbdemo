package live.cloverescape.lc.dfs;

/**
 * @author weibb
 */
public class LC547 {

    private boolean[] visited;
    private int m;

    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        m = isConnected.length;
        visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (visited[i]) {
                dfs(isConnected, i);
                ans++;
            }
        }
        return ans;
    }
    private void dfs(int[][] isConnected, int i) {
        visited[i] = true;
        for (int j = 0; j < m; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected, j);
            }
        }
    }
}
