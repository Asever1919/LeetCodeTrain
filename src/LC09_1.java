public class LC09_1 {
    public boolean isPalindrome(int x) {
        String s = x + "";
        char[] chars = s.toCharArray();
        travrsal(chars);
        String s1 = new String(chars);
        return s.equals(s1);
    }
    public void travrsal(char[] chars) {
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = chars[i];
            i++;
            j--;
        }
    }
}
