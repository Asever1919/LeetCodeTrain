import java.util.HashMap;

public class LC01 {
    public static void main(String[] args) {
        int target = 6;
        int[] nums = new int[]{3,2,4};
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

}
