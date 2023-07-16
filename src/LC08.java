public class LC08 {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        boolean flag = false;
        int start = 0;
        int len = chars.length;

        // 1 去掉前导空格
        while (start < len && chars[start] == ' ') start++;

        if (start == len) return 0;
        // 2 判断下一个字符是否为正负号
        if (chars[start] == '+') {
            start++;
        } else if (chars[start] == '-') {
            flag = true;
            start++;
        } else if (!Character.isDigit(chars[start])) {
            return 0;
        }
        // 3 判断下一个字符是不是非数字类型
        int ans = 0;
        while (start < len && Character.isDigit(chars[start])) {
            int dight = chars[start] - '0';
            if (ans > (Integer.MAX_VALUE - dight) / 10) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + dight;
            start++;
        }
        return flag ? -ans : ans;
    }
}
