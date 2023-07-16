package WeekExam;

public class LC6424 {
    public int semiOrderedPermutation(int[] nums) {
        int oneNum = 0;
        int oneNumIndex = -1;
        int nNum = 0;
        int nIndex = -1;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                oneNumIndex = i;
            }
            if (nums[i] == len) {
                nIndex = i;
            }
        }
        if (oneNumIndex > nIndex) return oneNumIndex + nIndex - 1;
        return oneNumIndex + nIndex;
        // 第一种情况：两者不交叉，二者分别移动步数相加就是结果
        // 第二种情况，两者交叉，二者分别移动步数相加-1，就是结果。
    }
}
