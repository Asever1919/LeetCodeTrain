import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.left = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root == null) return res;
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> path = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                path.add(node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }
}
