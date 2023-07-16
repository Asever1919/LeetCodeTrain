import java.util.Arrays;

public class LC674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int res = 1;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = dp[i - 1] + 1;
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}
