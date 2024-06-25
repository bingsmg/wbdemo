package live.cloverescape.lc.binarytree;


import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 */
public class LC105 {
    Map<Integer, Integer> map = new HashMap<>();
    int[] pre;

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = new LC105().buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = (preorder == null ? 0 : preorder.length);
        if (n == 0) return null;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        pre = preorder;
        return build(0, n - 1, 0, n - 1);
    }

    /**
     * 根据前序和中序序列构建二叉树
     * @param pl 前序左
     * @param pr 前序右
     * @param il 中序左
     * @param ir 中序右
     * @return root
     */
    private TreeNode build(int pl, int pr, int il, int ir) {
        if (pr < pl || ir < il) return null;
        int rootVal = pre[pl];
        int rootIdx = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = build(pl + 1, pl + rootIdx - il, il, rootIdx - 1);
        root.right = build(pl + rootIdx - il + 1, pr, rootIdx + 1, ir);
        return root;
    }
}
