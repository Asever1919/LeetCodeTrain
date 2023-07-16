package WeekExam;

public class LC6455 {
    public long minimumCost(String s) {
        
        long ans = 0;
        char[] S = s.toCharArray();
        for (int i = 1; i < S.length; i++) {
            if (S[i] != S[i - 1]) {
                ans += Math.min(i, S.length - i);
            }
        }
        return ans;
    }
}
