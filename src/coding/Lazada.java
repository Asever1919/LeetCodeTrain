package coding;

import java.util.*;
import java.util.Comparator;

public class Lazada {
    public static void main(String[] args) {

    }
    public String solution (int[] inputParam) {
        // write code here

        String[] strNums = new String[inputParam.length];
        for (int i = 0; i < inputParam.length; i++) {
            strNums[i] = String.valueOf(inputParam[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        if (strNums[0].equals("0")) {
            return "0";
        }
        String str = "";
        for (int i = 0; i < strNums.length; i++) {
            str += strNums[i];
        }
        return str;
    }
}
