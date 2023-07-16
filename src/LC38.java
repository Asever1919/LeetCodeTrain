import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC38 {
    public static void main(String[] args) {
        int n = 6;
        LC38 lc38 = new LC38();
        String s = lc38.countAndSay(n);
        System.out.println(s);
    }
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String strRes = "1";
        for (int i = 2; i <= n; i++) {
            strRes = read(strRes);
        }
        return strRes;
    }
    private String read(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (j <= str.length()) {

            if (j == str.length() || str.charAt(i) != str.charAt(j)){
                int num = j - i;
                sb.append(String.valueOf(num)).append(str.charAt(i));
                i = j;
                j++;
            } else if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
        }
        return sb.toString();
    }
}
