public class LC67 {
    public String addBinary(String a, String b) {
        // 非空判断。
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();

        // 进位计算。
        int count = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) count += a.charAt(i--) - '0';
            if (j >= 0) count += b.charAt(j--) - '0';
            sb.append(count % 2);
            count /= 2;
        }
        // 如果最后还有进位，要进行处理。
        String s = sb.reverse().toString();
        return count > 0 ? '1' + s : s;
    }
}
