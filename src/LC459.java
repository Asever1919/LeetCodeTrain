public class LC459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = new int[len];
        getNext(s,next);

        if ((len % (len - next[len - 1] + 1)  == 0 && next[len - 1] != 0)) {
            return true;
        }
        return false;
    }
    private void getNext(String s, int[] next) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
