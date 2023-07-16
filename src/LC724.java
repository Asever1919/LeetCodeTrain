public class LC724 {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) count += nums[i - 1];
            if (sum - count - nums[i] == count) return i;
        }
        return -1;
    }
}
