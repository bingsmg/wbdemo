package live.cloverescape.lc.binarytree;


import java.util.ArrayList;
import java.util.List;

/**
 * @author weibb
 */
public class LC98 {
    public static void main(String[] args) {
        TreeNode node = TreeTools.buildTree("[5,1,4,null,null,3,6]");
        LC98 lc98 = new LC98();
        boolean validBST = lc98.isValidBST(node);

    }

    List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        int n = res.size();
        if (n == 1) return true;
        for (int i = 1; i < n; i++) {
            if (res.get(i) < res.get(i - 1)) return false;
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        res.add(root.val);
        inorder(root.right);

    }
}
