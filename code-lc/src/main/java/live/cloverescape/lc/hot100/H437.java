package live.cloverescape.lc.hot100;

import java.util.Arrays;

/**
 * 我们首先定义 rootSum(p,val) 表示以节点 p 为起点向下且满足路径总和为 val 的路径数目。
 * 我们对二叉树上每个节点 p 求出 rootSum(p,targetSum)，然后对这些路径数目求和即为返回结果。
 *
 * 使用 dfs1 来搜索所有节点，复杂度为 O(n)；在 dfs1 中对于每个当前节点，使用 dfs2 搜索以其为根的所有（往下的）路径，同时累加路径总和为 targetSum 的所有路径，复杂度为 O(n)。
 * @author weibb
 * @date 2023-10-16
 */
public class H437 {
    private static final int a = 1000000000;
    private static final int b = 294967296;
    public static void main(String[] args) {
        int[] arr = {2, 4};
        int sum = Arrays.stream(arr).sum() / 2;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = rootSum(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    private int rootSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        if (root.val == targetSum) {
            ans++;
        }
        ans += rootSum(root.left, targetSum - root.val);
        ans += rootSum(root.right, targetSum - root.val);
        return ans;
    }


}
