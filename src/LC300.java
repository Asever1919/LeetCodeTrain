import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] +1);
            }
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
