package live.cloverescape.lc.houserob;

/**
 * @author weibb
 * @date 2023-11-07
 */
public class LC337 {
    public static void main(String[] args) {

    }

    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }
    // 返回以 node 为根节点的选择最大价值 ans[0]为当前节点偷 ans[1]为当前节点不偷
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        //根据当前结点偷或者不偷，就决定了需要从哪些子结点里的对应的状态转移过来。
        //
        //如果当前结点不偷，左右子结点偷或者不偷都行，选最大者；
        //如果当前结点偷，左右子结点均不能偷。
        int selected =  node.val + l[1] + r[1];
        int noSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, noSelected};
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}