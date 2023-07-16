package coding;

import java.util.HashMap;
import java.util.Map;

public class Exam {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {

        }
        for (int i = 0; i < S.length(); i++) {
            int j = i;
            int k = 0;
            while (S.charAt(j) == T.charAt(k)) {
                j++;
                k++;
            }
        }
    }
}
