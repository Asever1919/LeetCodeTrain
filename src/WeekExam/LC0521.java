package WeekExam;

import java.util.Arrays;
import java.util.Stack;

public class LC0521 {
    public int minLength(String s) {
//        ACBBD
        if (s.length() <= 1) return s.length();
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if ((stack.peek() == 'A' && s.charAt(i) == 'B') || (stack.peek() == 'C' && s.charAt(i) == 'D')) {
                    stack.pop();
                    len -= 2;
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return len;
    }
    public String makeSmallestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] nums = s.toCharArray();
        while (i < j) {
            if (nums[i] > nums[j]) {
                nums[i] = nums[j];
            } else {
                nums[j] = nums[i];
            }
            i++;
            j--;
        }
        String s1 = "";
        for (int k = 0; k < nums.length; k++) {
            s1 += nums[k];
        }
        return s1;
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 0; i <= n; ++i) {
            String s = Integer.toString(i * i);
            if (dfs(0, i, s, 0)) ans += i * i;
        }
        return ans;
    }
    public boolean dfs(int idx, int target, String s, int sum) {
        if (sum > target) {
            return false;
        }
        // 子字符串对应的整数值之和等于 i
        if (idx == s.length()) return sum == target;
        for (int j = idx, x = 0; j < s.length(); ++j) {
            x = x * 10 + (s.charAt(j) - '0');
            if (dfs(j + 1, target, s, sum + x)) return true;
        }
        return false;
    }
}
