import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC136 {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
//        return Arrays.stream(nums).reduce((a, b)->a^b).getAsInt();
//        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }
}
