public class LC114 {
    // 额外空间法：此题无返回值，所以最后要赋值到root上，在赋值之前，root的所有节点都要为空。

    // 原地修改发：
    public void flatten(TreeNode root) {
        if (root == null) return;
        // 后续遍历，避免对我们的已经排好的节点再进行修改。
        flatten(root.left);
        flatten(root.right);

        // 开始修改：
        // 保留右孩子
        TreeNode temp = root.right;
        // 将左孩子变成右孩子, 同时左孩子赋值为空。
        root.right = root.left;
        root.left = null;
        // 找到最底层的右孩子
        while (root.right!=null) {
            root = root.right;
        }
        // 将保留的右孩子赋值给最底层的右孩子。
        root.right = temp;
    }
}
