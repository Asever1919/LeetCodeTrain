public class LC28 {
    public static void main(String[] args) {
        LC28 lc28 = new LC28();
        int re = lc28.strStr("aabaabaafa","aabaaf");
        System.out.println("起始位置：" + re);
    }
    int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) j++;
            if (j == needle.length() - 1) {
                return i - j + 1;
            }
        }
        return -1;

    }
    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) j++;
            next[i] = j;
        }
    }

}
