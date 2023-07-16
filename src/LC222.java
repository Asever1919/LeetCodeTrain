public class LC222 {
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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            leftDepth++;
            right = right.right;
        }
        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
