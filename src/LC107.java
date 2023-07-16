import java.util.*;

public class LC107 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode () {};
        TreeNode (int val) {
            this.val = val;
        }
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
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
        Collections.reverse(res);
        return res;
    }
}
