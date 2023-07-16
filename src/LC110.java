public class LC110 {
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
    public boolean isBalanced(TreeNode root) {
        return getHight(root) != -1;
    }
    public int getHight(TreeNode root) {
        // 终止条件
        if(root == null) return 0;
        // 单层递归逻辑
        // 定义变量接住返回值
        int leftHight = getHight(root.left);
        if (leftHight == -1) {
            return -1;
        }
        int rightHight = getHight(root.right);
        if (rightHight == -1) {
            return -1;
        }
        if (Math.abs(leftHight - rightHight) > 1) return -1;
        return Math.max(leftHight, rightHight) + 1;
    }
}
