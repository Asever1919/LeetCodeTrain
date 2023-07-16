public class LCoffer58A2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int j = 0; j < n; j++) {
            sb.append(s.charAt(j));
        }
        return sb.toString();
    }
}
