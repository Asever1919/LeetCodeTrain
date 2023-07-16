public class LC654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        //注意所有都是左闭右开，需要严格遵守。
        return traversal(nums, 0, nums.length);
    }
    public TreeNode traversal(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return null;
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (nums[i] > maxValue) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = traversal(nums, leftIndex, maxIndex);
        root.right = traversal(nums, maxIndex + 1, rightIndex);
        return root;
    }
}
