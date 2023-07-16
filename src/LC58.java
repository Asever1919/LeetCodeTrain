public class LC58 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while(s.charAt(i) == ' ') {
            i--;
        }
        int j = i;
        while(i >=0 &&s.charAt(i) != ' ') i--;
        return j - i;
    }
}
