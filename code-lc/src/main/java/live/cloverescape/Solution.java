package live.cloverescape;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weibb
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(Boolean.FALSE.equals(null));
    }

    List<Integer> ans = new ArrayList<>();
    public boolean verifyTreeOrder(int[] postorder) {
        int n = postorder.length;
        if (n <= 1) return true;
        TreeNode root = build(postorder, 0, n - 1);
        traverse(root);
        for (int i = 0; i < n - 1; i++) {
            if (ans.get(i + 1) <= ans.get(i)) return false;
        }
        // 还原+中序遍历
        return true;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.left);
        ans.add(root.val);
        traverse(root.right);
    }

    public TreeNode build(int[] postorder, int pl, int pr) {
        if (pr < pl) return null;
        int idx = pr;
        for (int i = pl; i <= pr; i++) {
            if (postorder[i] > postorder[pr]) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(postorder[pr]);
        root.left = build(postorder, pl, idx - 1);
        root.right = build(postorder, idx, pr - 1);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}