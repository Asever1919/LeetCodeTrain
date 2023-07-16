import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC77 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        back(n, k, 1);
        return res;
    }
    private void back(int n, int k, int startIndex) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            back(n, k, i + 1);
            path.remove(path.size()- 1);
        }
    }
}
