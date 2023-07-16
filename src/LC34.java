public class LC34 {
    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', '0'};
        LC34 lc34 = new LC34();
        lc34.reverseString(s);
        System.out.println(s);
    }
    public void reverseString(char[] s) {
        if (s.length <= 1 || s == null) return;
        int i = 0;
        int j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}
