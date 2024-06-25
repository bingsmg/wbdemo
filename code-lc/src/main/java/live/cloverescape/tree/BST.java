package live.cloverescape.tree;

/**
 * @author weibb
 */
public class BST {

    TreeNode root;

    public void insert(int x) {
        insert(root, x);
    }

    public void remove(int x) {
        remove(root, x);
    }

    private TreeNode insert(TreeNode root, int x) {
        if (root == null) {
            root = new TreeNode();
            root.val = x;
            root.left = root.right = null;
        } else if (x < root.val) {
            root.left = insert(root.left, x);
        } else if (x > root.val) {
            root.right = insert(root.right, x);
        }
        return root;
    }

    private TreeNode find(TreeNode root, int x) {
        if (root == null) return null;
        else if (x < root.val) return find(root.left, x);
        else if (x > root.val) return find(root.right, x);
        else return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null) return null;
        else if (root.left == null) return root;
        return findMin(root.left);
    }

    private TreeNode findMax(TreeNode root) {
        if (root == null) return null;
        else if (root.right == null) return root;
        return findMax(root);
    }

    private TreeNode remove(TreeNode root, int x) {
        TreeNode tmp;
        if (root == null) return null;
        else if (x < root.val) root.left = remove(root.left, x);
        else if (x > root.val) root.right = remove(root.right, x);
        else {
            if (root.left != null && root.right != null) {
                tmp = findMin(root.right);
                root.val = tmp.val;
                root.right = remove(root.right, root.val);
            } else if (root.left == null) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}
