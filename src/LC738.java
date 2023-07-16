public class LC738 {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int startNine = chars.length - 2;
        for (int i = chars.length - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                startNine = i + 1;
            }
        }
        for (int j = startNine; j < chars.length; j++) {
            chars[j] = '9';
        }

//        return Integer.parseInt(chars.toString());
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args) {
        String s = "abc";
        char[] c = s.toCharArray();
        System.out.println(c.toString());
        System.out.println(String.valueOf(c));
        System.out.println(c.toString() == String.valueOf(c));
        System.out.println(c.toString().equals(String.valueOf(c)));

    }
}
