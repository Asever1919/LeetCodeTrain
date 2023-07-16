import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC90 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        if (nums.length == 0) return res;
        backtracing(nums, 0, used);
        return res;
    }
    private void backtracing(int[] nums, int startIndex, boolean[] used) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracing(nums, i + 1, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
