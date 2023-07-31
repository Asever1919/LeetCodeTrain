import java.util.HashMap;
import java.util.Map;

public class LC01 {
    public static void main(String[] args) {
        int target = 6;
        int[] nums = new int[]{3, 2, 4};
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            System.out.println("第" + i + "次" + num);
            if (map.containsKey(num)) {
                res[0] = i;
                System.out.println(res[0]);
                res[1] = map.get(num);
                System.out.println(res[1]);
            }
            map.put(nums[i], i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length < 2) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
