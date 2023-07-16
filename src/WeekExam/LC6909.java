package WeekExam;

public class LC6909 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        // index录最长奇偶的其实位置，只能为偶数。
        int index = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int length = 0;
            // 判断子串开头的位置是不是偶数，不是则进入下一个循环。
            if (nums[i] % 2 == 0) {
                index = i;
            } else {
                continue;
            }
            // 找到了偶数开头的字串。
            for (int j = index; j < nums.length; j++) {
                // 要满足题目要求串内元素 <= threshold
                if (index >= 0 && nums[j] <= threshold) {
                    // 相对位置应该放置对应元素，比如2345，3相对2的位置长度是1，那么3就是应该是奇数。
                    if ((j - index) % 2 == 1 && nums[j] % 2 == 1) {
                        length++;
                    } else if ((j - index) % 2 == 0 && nums[j] % 2 == 0) {
                        length++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }
}
