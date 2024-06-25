package live.cloverescape.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author weibb
 */
public class TreeTools {

    /**
     * 输入为数组，但是先转换字符串为数组
     * 类似 "[1,3,2,5,3,null,9]"
     * @param str 字符串
     * @return root
     */
    public static TreeNode buildTree(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] strNodes = str.substring(1, str.length() - 1).split(",");
        int[] nums = new int[strNodes.length];
        for (int i = 0; i < strNodes.length; i++) {
            if ("null".equals(strNodes[i])) {
                nums[i] = -1;
            } else {
                nums[i] = Integer.parseInt(strNodes[i]);
            }
        }
        return lcBuild(nums);
    }

    /**
     * 输入为类似 [1,3,2,5,3,-1,9]
     * 数组满足 i 处为 root, 2*i+1 为 left, 2*i+2 为 right
     * @param arr 数组
     */
    private static TreeNode build(int[] arr) {
        int n = (arr == null ? 0 : arr.length);
        TreeNode root = null;
        if (n == 0) return null;
        List<TreeNode> treeNodes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            TreeNode node = null;
            if (arr[i] != -1) {
                node = new TreeNode(arr[i]);
            }
            if (i == 0) root = node;
            treeNodes.add(node);
        }
        for (int i = 0; i * 2 + 2 < n; i++) {
            TreeNode node = treeNodes.get(i);
            if (node != null) {
                node.left = treeNodes.get(2 * i + 1);
                node.right = treeNodes.get(2 * i + 2);
            }
        }
        return root;
    }

    private static TreeNode lcBuild(int[] arr) {
        int n = (arr == null ? 0 : arr.length);
        if (n == 0) return null;
        TreeNode root = new TreeNode(arr[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (i < n) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (arr[i] != -1) {
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left);
                }
                i += 1;
                if (i < n && arr[i] != -1) {
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                i += 1;
            }
        }
        return root;
    }
}
