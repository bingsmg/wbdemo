package live.cloverescape.lc.binarytree;

import java.util.*;

/**
 * @author weibb
 */
public class LC297 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        LC297 lc297 = new LC297();
        String serialize = lc297.serialize(root);
        System.out.println(serialize);
        TreeNode node = lc297.deserialize(serialize);
        System.out.println("dfs end...");
        String serializeByBFS = lc297.serializeByBFS(root);
        System.out.println(serializeByBFS);
    }

    public String serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return "X";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Deque<String> deque = new LinkedList<>(Arrays.asList(nodes));
        return buildTree(deque);
    }

    private TreeNode buildTree(Deque<String> deque) {
        String node = deque.poll();
        if (Objects.equals(node, "X")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = buildTree(deque);
        root.right = buildTree(deque);
        return root;
    }

    public String serializeByBFS(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<String> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Objects.nonNull(node)) {
                res.add(String.valueOf(node.val));
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.add("X");
            }
        }
        return String.join(",", res);
    }

    public TreeNode deserializeByBFS(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode root = new TreeNode(Integer.parseInt(nodes.poll()));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            String left = nodes.poll();
            String right = nodes.poll();
            if (!Objects.equals(left, "X")) {
                node.left = new TreeNode(Integer.parseInt(left));
                deque.offer(node.left);
            }
            if (!Objects.equals(right, "X")) {
                node.right = new TreeNode(Integer.parseInt(right));
                deque.offer(node.right);
            }
        }
        return root;
    }
}
