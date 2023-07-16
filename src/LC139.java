import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }
}
