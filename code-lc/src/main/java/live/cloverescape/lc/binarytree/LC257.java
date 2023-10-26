package live.cloverescape.lc.binarytree;

import java.util.*;

/**
 * @author weibb
 * @date 2023-10-17
 */
public class LC257 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        LC257 lc257 = new LC257();
        List<String> ans = lc257.binaryTreePaths(root);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    private final List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new LinkedList<>());
        return ans;
    }

    public void dfs(TreeNode root, Deque<String> path) {
        if (root == null) {
            return;
        }
        path.offerLast(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            ans.add(String.join("->", path));
        }
        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }
        path.pollLast();
    }
}
