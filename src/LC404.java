import java.util.LinkedList;
import java.util.Queue;

public class LC404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> que = new LinkedList<>();
        int res = 0;
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                res += node.left.val;
            }
            if (node.left != null) que.offer(node.left);
            if (node.right != null) que.offer(node.right);
        }
        return res;
    }
}
