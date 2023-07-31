import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC47 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        LC47 lc47 = new LC47();
        int[] nums = {1, 1, 2};
        lc47.permuteUnique(nums);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backing(nums, used);
        return res;
    }

    private void backing(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (used[i] == true) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backing(nums, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
