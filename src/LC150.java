import java.util.Stack;

public class LC150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                st.push(st.pop() + st.pop());
            } else if ("-".equals(tokens[i])) {
                st.push(-st.pop() + st.pop());
            } else if ("*".equals(tokens[i])) {
                st.push(st.pop() * st.pop());
            } else if ("/".equals(tokens[i])) {
                int temp1 = st.pop();
                int temp2 = st.pop();
                int a = temp2 / temp1;
                st.push(a);
            } else {
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.pop();
    }
}
