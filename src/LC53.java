public class LC53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int count = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > res) res = Math.max(count, res);
            if (count < 0) count = 0;
        }
        return res;
    }
}
