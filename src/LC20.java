import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        char[] ch = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                st.push(')');
            } else if(ch[i] == '{') {
                st.push('}');
            } else if(ch[i] == '[') {
                st.push(']');
            } else if(st.isEmpty() || ch[i] != st.peek()) {
                return false;
            } else {
                st.pop();
            }
        }
        return st.isEmpty();
    }
}
