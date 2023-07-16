public class LC968 {
//    0：该节点无覆盖
//    1：本节点有摄像头
//    2：本节点有覆盖*/
    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (traversal(root) == 0) res++;
        return res;
    }
    public int traversal (TreeNode root) {
        if (root == null) return 2;
        int left = traversal(root.left);
        int right = traversal(root.right);

        if (left == 2 && right == 2) {
            return 0;
        } else if(left == 0 || right == 0) {
            res++;
            return 1;
        } else if (left == 1 || right == 1) {
            return 2;
        }
        return -1;
    }
}
