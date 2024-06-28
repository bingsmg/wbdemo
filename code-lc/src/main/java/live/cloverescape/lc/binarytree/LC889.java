package live.cloverescape.lc.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weibb
 */
public class LC889 {

    public static void main(String[] args) {
        LC889 lc889 = new LC889();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode treeNode = lc889.constructFromPrePost(preorder, postorder);
    }

    Map<Integer, Integer> map = new HashMap<>();
    int[] pre;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = (postorder == null ? 0 : postorder.length);
        if (n == 0) return null;
        for (int i = 0; i < n; i++) {
            map.put(postorder[i], i);
        }
        pre = preorder;
        return build(0, n - 1, 0, n - 1);
    }

    private TreeNode build(int prel, int prer, int postl, int postr) {
        if (prer < prel || postr < postl) return null;
        TreeNode root = new TreeNode(pre[prel]);
        int preIdx = prel + 1, postIdx = map.get(pre[preIdx]);
        int len = postIdx - postl + 1;
        System.out.printf("root = %d \n", pre[prel] );
        System.out.printf("root.left = build[%d, %d, %d, %d]\n", prel + 1, prel + len, postl, postIdx);
        if (len != 1) {
            root.left = build(prel + 1, prel + len, postl, postIdx);
            System.out.printf("root.right = build[%d, %d, %d, %d]\n", prel + len + 1, prer, postIdx + 1, postr - 1);
            root.right = build(prel + len + 1, prer, postIdx + 1, postr - 1);
        }
        return root;
    }
}
