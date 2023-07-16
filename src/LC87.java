public class LC87 {
    public boolean isScramble(String s1, String s2) {
        return false;
    }
    // 遵顼左闭右开
    private boolean travesal(String s1, String s2, int index, int start, int end) {
        if (start > end) return false;
        for (int i = start; i < end; i++) {
            String str = swap(s1, i, start, end);
            if (str.equals(s2)) return true;

        }
        return false;
    }
    private String swap(String s, int index, int left, int right) {
        if (left >= right) return s;
        return s.substring(index + 1, right) + s.substring(left, index + 1);
    }
}
