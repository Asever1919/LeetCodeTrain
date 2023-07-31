public class LC53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 这里需要记录下最大结果，因为状态转移方程不包括dp[i - 1];
            // The maximum result needs to be recorded here because the state transition equation does not include dp[i - 1];
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
