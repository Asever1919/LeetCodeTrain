public class LC98 {
    int pre = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (isValidBST(root.left)) {
            return true;
        }
        if (pre > root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }
}
