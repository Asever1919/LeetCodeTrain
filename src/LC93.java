import java.util.ArrayList;
import java.util.List;

public class LC93 {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracing(s, 0, 0);
        return res;
    }
    private void backtracing(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                res.add(s);
                return;
            }
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                pointNum++;
                backtracing(s, i + 2, pointNum);
                s = s.substring(0, i + 1) + s.substring(i + 2);
                pointNum--;
            } else {
                break;
            }
        }
    }
    private boolean isValid(String s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            num = 10 * num + (s.charAt(i) - '0');
            if (num > 255) return false;
        }
        return true;
    }
}
