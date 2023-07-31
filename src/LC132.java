import java.lang.reflect.Array;
import java.util.Arrays;

public class LC132 {
    public int minCut(String s) {
        int len = s.length();

        // 创建一个二维数组dp，用于存储从i到j的子串是否为回文串的状态
        boolean[][] dp = new boolean[len][len];

        // 动态规划，判断从i到j之间的子串是否为回文串
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // 若s的第i个字符和第j个字符相等
                // 并且子串长度(j - i)小于等于1（长度为0的子串为回文串，长度为1的子串也为回文串）
                // 或者内部的子串s[i+1][j-1]也为回文串
                // 则当前子串s[i][j]为回文串
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        // 创建一个一维数组fp，用于存储到达每个位置的最小分割次数
        int[] fp = new int[len];

        // 初始化fp数组，假设每个位置都需要分割一次
        for (int i = 0; i < len; i++) {
            fp[i] = i;
        }

        // 动态规划，计算到达每个位置的最小分割次数
        for (int i = 1; i < len; i++) {
            // 若从0到i的整个子串是回文串，则不需要进行分割
            if (dp[0][i]) {
                fp[i] = 0;
                continue;
            }

            // 尝试从j位置处分割字符串，将字符串分为两部分
            for (int j = 0; j < i; j++) {
                // 若从j+1到i的子串是回文串
                // 则更新到达当前位置i的最小分割次数，取之前的最小分割次数fp[i]和fp[j]+1的较小值
                if (dp[j + 1][i]) {
                    fp[i] = Math.min(fp[i], fp[j] + 1);
                }
            }
        }

        // 返回最后一个位置的最小分割次数
        return fp[len - 1];
    }
}
