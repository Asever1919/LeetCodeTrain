import java.util.HashMap;

public class LC003 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int lowIndex = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(lowIndex)) {
                lowIndex++;
            }
            System.out.println(i);
            System.out.println(lowIndex);
            res = Math.max(res, i - lowIndex + 1);
            System.out.println(res);
            System.out.println("================");
        }

    }
}
