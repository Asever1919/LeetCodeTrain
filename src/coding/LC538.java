package coding;



public class LC538 {
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
    int pre;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        if (root == null) return root;
        traversal(root);
        return root;
    }
    public void traversal (TreeNode root) {
        if (root == null) return;
        traversal(root.right);
        root.val += pre;
        pre = root.val;
        traversal(root.left);
    }
}
