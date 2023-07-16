import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC216 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        back(k, n, 1, 0);
        return res;
    }
    public void back(int k, int n, int startIndex, int sum) {
        if (sum > n) return;
        if (path.size() == k) {
            // 这里一定要注意，一定是先满足个数要求，在满足和的要求
            if (sum == n) res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            back(k, n, i + 1, sum);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
