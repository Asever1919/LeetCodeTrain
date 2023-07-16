public class LC151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        LC151 lc151 = new LC151();
        s = lc151.reverseWords(s);
        System.out.println(s);
    }
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverseAllWords(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    /**
     *
     * @param s : 输入的字符串
     * @return ： 返回的是一个可变字符串。
     */
    private StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = s.length() - 1;
        while (s.charAt(i) == ' ' && i < s.length()) i++;
        while (s.charAt(j) == ' ' && j >= 0) j--;
        for (int k = 0; k <= j; k++) {
            if (s.charAt(k) != ' ' && sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(k));
            }
        }
        return sb;
    }
    private void reverseAllWords(StringBuilder sb, int start, int end) {
        if (start >= end) return;
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = start + 1;
        int len = sb.length();
        while (start < len) {
            while (sb.charAt(end) != ' ' && end < len) end++;
            reverseAllWords(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
