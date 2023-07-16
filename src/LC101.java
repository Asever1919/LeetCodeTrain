import java.util.LinkedList;
import java.util.Queue;

public class LC101 {
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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root.left);
        que.offer(root.right);
        while (!que.isEmpty()) {
            TreeNode leftNode = que.poll();
            TreeNode rightNode = que.poll();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null || (leftNode.val != rightNode.val)) return false;
            que.offer(leftNode.left);
            que.offer(rightNode.right);
            que.offer(leftNode.right);
            que.offer(rightNode.left);
        }
        return true;
    }
    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null || (left.val != right.val)) return false;
        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);
        return  outSide && inSide;
    }
}
