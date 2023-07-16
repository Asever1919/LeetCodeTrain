package WeekExam;

import java.util.Arrays;
import java.util.Map;

public class LC6393 {
    public static void main(String[] args) {
        LC6393 lc6393 = new LC6393();
        int[] nums = {3, -1, -5, 2, 5, -9};
        long res = lc6393.maxStrength(nums);
        System.out.println(res);
    }
    public long maxStrength(int[] nums) {
        long max = nums[0];
        long min = nums[0];
        long res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            long temp = max;
            System.out.println(max * nums[i]);
            System.out.println(min * nums[i]);
            System.out.println(nums[i]);
            System.out.println(max * nums[i]);
            // max * nums[i] : 当前值*之前的最大值
            // min * nums[i] : 当前值*之前的最小值
            // nums[i] : 只要当前值，比如[0, 1]
            // max : 只要最大值，比如[1, -1]
            max = Long.max(Long.max(Long.max(max * nums[i], min * nums[i]), nums[i]), max);
            System.out.println("--------------");
            System.out.println(temp * nums[i]);
            System.out.println(min * nums[i]);
            System.out.println(nums[i]);
            System.out.println(min * nums[i]);
            min = Long.min(Long.min(Long.min(temp * nums[i], min * nums[i]), nums[i]), min);
            System.out.println("==============");
        }
        return Long.max(res, max);
    }
}
