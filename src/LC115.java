public class LC115 {
    public int numDistinct(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        // 以s[i - 1] 和 t[j - 1] 为结尾的s的子序列在t中出现的个数。
        int[][] dp = new int[lenS + 1][lenT + 1];
        for (int i = 0; i <= lenS; i++) {
            // 空字符串在t中出现一次。
            dp[i][0] = 1;
        }
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenT; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][ - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[lenS][lenT];
    }
}
