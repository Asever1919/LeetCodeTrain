package coding;

import java.util.Scanner;

public class JinShanYun063001 {
    public static void main(String[] args) {
        int N = 3;
        int[][] cheese = {{10, 0, 0}, {1, 12, 0}, {1, 12, 20}};
        int[][] dp = new int[N][N];
        dp[0][0] = cheese[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + cheese[i][0];
            if (i == N - 1) {
                dp[i][i] = cheese[i][i];
            } else {
                dp[i][i] = dp[i][i - 1] + cheese[i][i];
            }
            for (int j = 1; j < i; j++) {
                if (i == N - 1) {
                    dp[i][j] = dp[i - 1][j] + cheese[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + cheese[i][j];
                }
            }
        }
        int max = -1;
        for (int i = 0; i < N - 1; i++) {
            max = Math.max(dp[N - 1][i], max);
        }
        System.out.println(max);
    }
}
