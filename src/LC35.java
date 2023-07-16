public class LC35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right + left) >> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return right;
    }
}
