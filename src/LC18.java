import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4 || nums == null) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) return res;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] > target) {
                        r--;
                    } else if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        List<Integer> path = new LinkedList<>();
                        path.add(nums[i]);
                        path.add(nums[j]);
                        path.add(nums[l]);
                        path.add(nums[r]);
                        res.add(new ArrayList<>(path));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
