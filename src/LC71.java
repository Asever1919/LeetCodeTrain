import java.util.Stack;

public class LC71 {
    public static void main(String[] args) {
        LC71 lc71 = new LC71();
        String path = "/home/";
        lc71.simplifyPath(path);
    }

    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> st = new Stack<>();
        for (String str : split) {
            if (str.equals("..") && !st.isEmpty()) st.pop();
            if (!str.equals(".") && !str.equals("..") && !str.equals("")) st.push(str);
            System.out.println(st.size());
        }
//        for(String str : split) {
//            if(str.equals("..") && !stack.isEmpty()) stack.pop();
//            if(!str.equals(".") && !str.equals("..")&& !str.equals("")) stack.push(str);
//        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
            sb.insert(0, "/");
            System.out.println(sb.toString());
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}
