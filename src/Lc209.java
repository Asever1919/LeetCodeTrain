public class Lc209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int result = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        int minLength = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            System.out.println("每层的和为：" + sum);
            while (sum >= target) {
                minLength = j - i + 1;
                System.out.println("最小长度：" + minLength);
                //直接j - i的话，是不包括i或者j的，但是滑动窗口是包含i和j的，所以需要加1。
                // result = result < minLength ? result : minLength;
                if (result > minLength) {
                    result = minLength;
                }
                sum -= nums[i];
                i++;
            }
        }

    }
}
