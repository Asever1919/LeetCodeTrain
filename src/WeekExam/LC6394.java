package WeekExam;

import java.util.HashSet;
import java.util.Set;

public class LC6394 {
    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = {"leet","code","leetcode"};
        LC6394 lc6394 = new LC6394();
        lc6394.minExtraChar(s, dictionary);
    }
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dic = new HashSet<>();
        for (String str : dictionary) {
            dic.add(str);
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1] = dp[i] + 1;
            for (int j = 0; j <= i; j++) {
                if (dic.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j]);
                    System.out.println(dp[i + 1]);
                }
            }
        }
        return dp[s.length()];
    }
}
