public class LC189 {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1) return;
        int n = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, n - 1);
        swap(nums, n, nums.length - 1);
    }
    private void swap(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
