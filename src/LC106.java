import java.util.HashMap;
import java.util.Map;

public class LC106 {
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(inorder, 0, inorder.length,
                postorder, 0, postorder.length);
    }
    public TreeNode traversal (int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        if (inEnd <= inBegin || postEnd <= postBegin) return null;
        int rootIndex = map.get(postorder[postEnd - 1]);
        int rootValue = inorder[rootIndex];
        TreeNode root = new TreeNode(rootValue);
        int leftLen = rootIndex - inBegin;
        root.left = traversal(inorder, inBegin, rootIndex, postorder, postBegin, postBegin + leftLen);
        root.right = traversal(inorder, rootIndex + 1, inEnd, postorder, postBegin + leftLen, postEnd - 1);
        return root;
    }
}
