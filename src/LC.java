public class LC {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int curDistance = 0;
        int cover = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (curDistance == i) {
                res++;
                curDistance = cover;
                if (curDistance >= nums.length - 1) break;
            }
        }
        return res;
    }
}
