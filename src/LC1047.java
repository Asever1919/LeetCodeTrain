import java.util.Stack;

public class LC1047 {
    public String removeDuplicates(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (!stack.isEmpty() && stack.peek() == ch[i]) {
                stack.pop();
            } else {
                stack.push(ch[i]);
            }
        }
        if (stack.isEmpty()) return "";
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;
        }
        return str;
    }
}
