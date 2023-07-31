import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC38 {
    public static void main(String[] args) {
        int n = 4;
        LC38 lc38 = new LC38();
        String s = lc38.countAndSay(n);
        System.out.println(s);
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = "1";
        while (n-- > 1) {
            s = read(s);
        }
        return s;
    }

    private String read(String str) {
        int len = str.length();
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (j <= len) {
            if ((j < len &&str.charAt(i) != str.charAt(j)) || j == len) {
                int num = j - i;
                char c = str.charAt(i);
                sb.append(num).append(c);
                i = j;
                j++;
            } else if (str.charAt(i) == str.charAt(j)){
                j++;
            }
        }
        return sb.toString();
    }

}
