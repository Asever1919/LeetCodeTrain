public class LC416 {
    public boolean canPartition(int[] nums) {
        if (nums == null) return false;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length && !dp[i]; i++) {
            for (int j = target; j >= nums[i] && dp[j]; j-- ) {
                if (dp[j - nums[i]]) dp[j] = true;
            }
        }
        return dp[nums.length];
    }
}
