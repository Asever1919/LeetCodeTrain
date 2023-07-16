public class LC718 {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                res = res > dp[i][j] ? res : dp[i][j];
            }
        }
        return res;
    }
}
