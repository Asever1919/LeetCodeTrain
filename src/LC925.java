public class LC925 {
    public boolean isLongPressedName(String name, String typed) {
        int len1 = name.length();
        int len2 = typed.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                /**
                 * ab和abb，这种对应下面两种。
                 */
                if (name.charAt(i - 1) == typed.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
