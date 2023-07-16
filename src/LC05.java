public class LC05 {
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        dp[0][0] = 0;
        for (int i = len -1; i >= 0; i--) {
            for (int j = i; j <= len - 1; j++) {
                if (s.charAt(i + 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return "";
    }
}
