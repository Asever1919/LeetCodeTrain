import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return res;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    List<Integer> path = new LinkedList<>();
                    path.add(nums[i]);
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(new ArrayList<>(path));
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
