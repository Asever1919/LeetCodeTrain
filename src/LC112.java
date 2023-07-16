import java.util.Stack;

public class LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 如果根节点为null, 直接返回false(遍历到头都没有找到目标值，证明路径上没有，则返回false)
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return root.val == targetSum;
        } else {
            return hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val);
        }
    }
}
