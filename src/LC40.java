import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracing(candidates, target, 0, used, 0);
        return res;
    }
    private void backtracing(int[] candidates, int target, int sum, boolean[] used, int startIndex) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) continue;
            sum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backtracing(candidates, target, sum, used, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
