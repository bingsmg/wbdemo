package live.cloverescape.tree;

/**
 * @author weibb
 */
public class LC114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        new TreeNode(4, null, null)),
                new TreeNode(5,
                        null,
                        new TreeNode(6, null, null)));
        new LC114().flatten(root);
        while (root.right != null) {
            System.out.print(root.val + "->");
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
        TreeNode aux = new TreeNode();
        preorder(root, aux);
        root = aux.right;
    }

    private void preorder(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        p.right = root;
        p = p.right;
        preorder(root.left, p);
        preorder(root.right, p);
    }

}
