public class LCjzoffer05 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else {
                sb.append(s.charAt(i));
            }
        }
        return new String(sb);
    }
}
