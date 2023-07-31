import java.util.HashSet;
import java.util.Set;

public class LC128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int n = nums.length;
        int maxLong = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        // 遍历set中的每个元素
        for (int num : set) {
            // 规定只有当前节点作为连续序列的起点时，才可以计算长度
            if(!set.contains(num - 1)) {
                int curnum = num;
                int curLong = 0;
                // 这个循环就是不断的判断下一个元素是不是在set中。
                while (set.contains(curnum)) {
                    curnum++;
                    curLong++;
                }
                maxLong = Math.max(curLong, maxLong);
            }
        }
        return maxLong;
    }
}
