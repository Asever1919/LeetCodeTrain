import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LC1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 排序
        nums = IntStream
                .of(nums)
                .boxed()
                .sorted(((o1, o2) -> Math.abs(o2) - Math.abs(o1)))
                .mapToInt(Integer::intValue)
                .toArray();


        // 遇到负号就翻转
        for (int i = 0; i < nums.length && k > 0; i++) {
            if (nums[i] < 0 ) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // 如果k没用完，就反转最后一个。
        while (k-- > 0) {
            nums[nums.length - 1] = -nums[nums.length - 1];
        }
        // 求和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
