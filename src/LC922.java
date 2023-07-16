public class LC922 {
    public int[] sortArrayByParityII(int[] nums) {
        int ou = 0;
        int ji = 1;
        int n = nums.length;
        while (ou < n && ji < n) {
            while (ou < n && nums[ou] % 2 == 0) ou += 2;
            while (ji < n && nums[ji] % 2 == 1) ji += 2;
            if (ou < n && ji < n) {
                int temp = nums[ou];
                nums[ou] = nums[ji];
                nums[ji] = temp;
            }
            ou += 2;
            ji += 2;
        }
        return nums;
    }
}
