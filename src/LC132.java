import java.lang.reflect.Array;
import java.util.Arrays;

public class LC132 {
    public int minCut(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        int[] fp = new int[len + 1];
        Arrays.fill(fp, len - 1);
        fp[0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[j][i]) fp[i] = Math.min(fp[i], fp[j - 1] + 1);
            }
        }
        return fp[len] - 1;
    }
}
