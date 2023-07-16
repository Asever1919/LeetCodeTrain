public class LC337 {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }
    private int[] robTree(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;

        int[] left = robTree(root.left);
        int[] right = robTree(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
