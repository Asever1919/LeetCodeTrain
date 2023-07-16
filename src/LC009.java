public class LC009 {
    public static void main(String[] args) {
        LC009 lc009 = new LC009();
        boolean flag = lc009.isPalindrome(121);
        System.out.println(flag);
    }
    public boolean isPalindrome(int x) {
//        String s = x + "";
//        char[] chars = s.toCharArray();
//        char[] pre = chars;
//        System.out.println(pre);
//        swap(chars);
//        System.out.println(chars);
//        if (chars.equals(pre)) return true;
//        return false;

        String s = x + "";
        char[] chars = s.toCharArray();
        // 如果两个数组同时指向一个地址，那么转化为字符串之后比较的也是地址。
        swap(chars);
        String s1 = String.copyValueOf(chars);
        if (s == s1) return true;
        return false;
    }
    public void swap(char[] chars) {
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
