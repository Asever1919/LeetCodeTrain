public class LC977 {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] res = new int[nums.length];
        int k = res.length;
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[k++] = nums[i] * nums[i];
                i++;
            } else {
                res[k++] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }
}
