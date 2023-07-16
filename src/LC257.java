import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> path = new LinkedList<>();
        traversal(root, res, path);
        return res;
    }
    public void traversal(TreeNode root, List<String> res, List<Integer> path) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            res.add(sb.toString());
            return;
        }
        if (root.left != null) {
            traversal(root.left, res, path);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right, res, path);
            path.remove(path.size() - 1);
        }
    }
}
