public class LC45 {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curDitance = 0;
        int nextDitance = 0;
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            nextDitance = Math.max(nextDitance, nums[i] + i);
            if (i == curDitance) {
                res++;
                curDitance = nextDitance;
                if (curDitance >= nums.length - 1) break;
            }
        }
        return res;
    }
}
