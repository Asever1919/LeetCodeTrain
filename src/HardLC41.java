public class HardLC41 {
    public int firstMissingPositive(int[] nums) {
        // 1. 将数组中所有小于等于0的数字否赋值为数组长度+1；
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 2. 将在[1，n]范围的数看作下标，将下标所对应的nums的数变为绝对值的负数。
        for (int i = 0; i < n; i++) {
            // 这个num是会被重复利用的，要保证是正数。
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 3. 寻找第一个正整数，返回其下标+1。
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
