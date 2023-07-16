import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC39 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtracing(candidates, target, 0, 0);
        return res;
    }
    private void backtracing(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtracing(candidates, target, sum, i);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}
