import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            if (!map.containsKey(res[i])) {
                map.put(res[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                nums[i] = map.get(nums[i]);
            }
        }
        return nums;
    }
}
