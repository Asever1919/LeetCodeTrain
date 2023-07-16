import java.util.Arrays;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        // 建立dp数组，表示i处的所需的最少硬币个数。
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        return dp[amount];
    }
}
