public class LC6 {
    public String convert(String s, int numRows) {
        if (s.length() == 1) return s;
        int k = 0;
        char[][] cheese = new char[numRows][500];
        // i控制的是字符数量。
        for (int i = 0; i < s.length();) {
            // 填满竖行。
            for (int j = 0; j < numRows; j++) {
                cheese[j][k] = s.charAt(i);
                i++;
            }
            // 填满中间斜行位置。
            for (int h = numRows - 2; h > 0 && i < s.length() ; h--) {
                ++k;
                cheese[h][k] = s.charAt(i);
            }
            ++k;

        }
        // \u0000 代表的是空字符，属于控制字符，也叫不可显字符。
        String str = "";
        for (char[] p : cheese) {
            for (char q : p) {
                if (q != '\u0000') str += q;
            }
        }
        return str;
    }
}
