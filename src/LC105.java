import java.util.HashMap;
import java.util.Map;

public class LC105 {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return root;
    }
    private TreeNode traversal(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) return null;

        int rootValue = preorder[preBegin];
        int rootIndex = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);

        int leftLen = rootIndex - inBegin;
        root.left = traversal(preorder, preBegin + 1, preBegin + 1 + leftLen, inorder, inBegin, rootIndex);
        root.right = traversal(preorder, preBegin + 1 + leftLen, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
