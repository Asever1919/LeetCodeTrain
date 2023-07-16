import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC46 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null) return res;
        boolean[] used = new boolean[nums.length];
        backtracing(nums, used);
        return res;
    }
    private void backtracing(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracing(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
