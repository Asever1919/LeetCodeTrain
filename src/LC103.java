import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            List<Integer> path = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if (depth % 2 == 1) {
                    path.add(node.val);
                } else {
                    path.add(0, node.val);
                }
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            res.add(new ArrayList<>(path));
        }
        return res;
    }
}
