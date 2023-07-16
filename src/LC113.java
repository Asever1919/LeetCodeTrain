import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC113 {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null) return res;
        path = new LinkedList<>();
        traversal(root, targetSum);
        return res;
    }
    private void traversal (TreeNode root, int targetSum) {
        path.add(root.val);
        // 遍历到叶子节点，就需要判断是不是目标路径了
        if (root.left == null && root.right == null) {
            if(targetSum - root.val == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if (root.left != null) {
            traversal(root.left,targetSum - root.val);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            traversal(root.right,targetSum - root.val);
            path.remove(path.size() - 1);
        }
    }
}
