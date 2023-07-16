import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC131 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    public List<List<String>> partition(String s) {
        if (s.length() == 0) return res;
        backtracing(s, 0);
        return res;
    }
    private void backtracing(String s, int index) {
        if (s.length() == index) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPoliRome(s, index, i)) {
                path.add(s.substring(index, i + 1));
            } else continue;
            backtracing(s, i + 1);
            path.remove(path.size() - 1);
        }
    }
    private boolean isPoliRome (String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
