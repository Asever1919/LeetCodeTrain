import java.util.LinkedList;
import java.util.Queue;

public class LC226 {
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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) return root;
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                swap(node);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return root;
    }
    public void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
