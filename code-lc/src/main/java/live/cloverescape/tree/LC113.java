package live.cloverescape.tree;

import java.util.*;

/**
 * @author weibb
 */
public class LC113 {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        TreeNode root = TreeTools.buildTree("[25,1,3,1,3,0,2]");
        LC113 lc113 = new LC113();
        List<String> res = new ArrayList<>();
        lc113.pathSum(root, new StringBuilder(), res);
        for (String re : res) {
            System.out.println(re);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void pathSum(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        targetSum -= root.val;
        if (targetSum < 0) return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        pathSum(root.left, targetSum, path, res);
        pathSum(root.right, targetSum, path, res);
        path.remove(path.size() - 1);
    }

    public String smallestFromLeaf(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        pathSum(root, path, res);
        Collections.sort(res);
        return res.get(0);
    }

    private void pathSum(TreeNode root, StringBuilder path, List<String> res) {
        if (root == null) return;
        char c = (char)('a' + root.val);
        path.append(c);
        if (root.left == null && root.right == null) {
            res.add(path.reverse().toString());
            path.reverse();
        }
        pathSum(root.left, path, res);
        pathSum(root.right, path, res);
        path.deleteCharAt(path.length() - 1);
    }
}
