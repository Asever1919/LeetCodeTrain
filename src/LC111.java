public class LC111 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val){this.val = val;}
        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left != null && root.right == null) return leftDepth + 1;
        if (root.right != null && root.left == null) return rightDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
