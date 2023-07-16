import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC144 {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        // 统一迭代法解决前中后序遍历
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root == null) return res;
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null);
            } else {
                st.pop();
                res.add(st.pop().val);
            }
        }
        return res;
    }
    public List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }
    public void traversal (TreeNode cur, List<Integer> res) {
        if (cur == null) return;
        res.add(cur.val);
        traversal(cur.left, res);
        traversal(cur.right, res);
    }
}