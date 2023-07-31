public class LC124 {
    // 定义一个最大路径和
    int maxSum;

    public int maxPathSum(TreeNode root) {
        // 初始化最大路径和
        maxSum = Integer.MIN_VALUE;

        // 计算最大路径和
        getMaxSum(root);
        // 返回最大路径和
        return maxSum;
    }

    // 计算最大路径和
    private int getMaxSum(TreeNode root) {
        if (root == null) return 0;

        // 左子树的最大路径和
        int leftSum = Math.max(0, getMaxSum(root.left));
        // 右子树的最大路径和
        int rightSum = Math.max(0, getMaxSum(root.right));

        // 算上当前节点的最大路径和
        int curSum = root.val + leftSum + rightSum;
        maxSum = curSum > maxSum ? curSum : maxSum;

        // 返回给上一层的数值，必然只能加左右孩字的最大值。
        return root.val + Math.max(leftSum, rightSum);
    }
}
