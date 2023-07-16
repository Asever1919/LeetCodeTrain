public class LC188 {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2 * k + 1];
        // 记住，买卖两次的进阶版本，之前是奇数买入，偶数卖出，所以，要对奇数位进行赋值。
        // 其实可以在第一天进行了所有的买卖，所以才如此进行初始化。
        for (int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][2 * k];
    }
}
