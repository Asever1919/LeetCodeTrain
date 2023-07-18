public class HardLC124 {
    // 定义一个全局变量来保存最大路径和
    int maxSum;

    public int maxPathSum(TreeNode root) {
        // 初始化最大路径和为最小值
        maxSum = Integer.MIN_VALUE;

        // 递归计算最大路径和
        getMaxSum(root);

        // 返回最大路径和
        return maxSum;
    }

    private int getMaxSum(TreeNode node) {
        // 如果节点为空，返回0
        if (node == null) {
            return 0;
        }

        // 递归计算左子树的最大路径和
        int leftSum = Math.max(0, getMaxSum(node.left));

        // 递归计算右子树的最大路径和
        int rightSum = Math.max(0, getMaxSum(node.right));

        // 计算当前节点的最大路径和（可以选择不经过当前节点）
        int currentSum = node.val + leftSum + rightSum;

        // 更新最大路径和
        maxSum = Math.max(maxSum, currentSum);

        // 返回以当前节点为根的最大路径和（只能选择经过当前节点的一条路径）
        return node.val + Math.max(leftSum, rightSum);
    }
}
