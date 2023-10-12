package live.cloverescape.lc.hot100;

/**
 * @author weibb
 * @date 2023-10-11
 */
public class H538 {

    public static int sum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(1,
                        new TreeNode(0, null, null),
                        new TreeNode(2,
                                null,
                                new TreeNode(3, null, null))),
                new TreeNode(6,
                        new TreeNode(5, null, null),
                        new TreeNode(7,
                                null,
                                new TreeNode(8, null, null))));
        H538 h538 = new H538();
        h538.convertBST(root);
        h538.traverse(root);
    }

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
