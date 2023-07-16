public class LC129 {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        traversal(root,0);
        return sum;
    }
    private void traversal(TreeNode root, int val) {
        if (root == null)return;
        int k = 10*val + root.val;
        if (root.left == null && root.right == null) sum += k;
        traversal(root.left, k);
        traversal(root.right, k);
    }
}
