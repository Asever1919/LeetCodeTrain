import java.util.ArrayList;
import java.util.List;

public class LC17 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] strNum = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LC17 lc17 = new LC17();
        lc17.letterCombinations("23");
    }
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        backing(digits, 0);
        return res;
    }
    public void backing(String digits, int index) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        System.out.println("下标为：" + digit);
        String letter = strNum[digit];
        for (int i = 0; i < letter.length(); i++) {
            sb.append(letter.charAt(i));
            backing(digits, index +1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
