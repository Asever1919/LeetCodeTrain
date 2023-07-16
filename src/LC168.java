public class LC168 {
    public static String convertToTitle(int columnNumber) {
        String s = "";
        while (columnNumber > 0) {
            columnNumber--;
            int num = columnNumber % 26;
            char c= (char) (num + 'A');
            s = c + s;
            columnNumber = columnNumber / 26;
        }
        return s;
    }

    public static void main(String[] args) {
        String s = convertToTitle(701);
        System.out.println(s);
    }
}
