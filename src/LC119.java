import java.util.ArrayList;
import java.util.List;

public class LC119 {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) return res;
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }
        for (int i = 2; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                if (i == rowIndex) {
                    res.add(dp[i][j]);
                }
            }
        }
        res.add(1);
        return res;
    }
}
