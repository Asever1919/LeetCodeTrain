public class LC137 {
    public int singleNumber(int[] nums) {
        int ret = 0; // 初始化返回的结果为0
        for (int i = 0; i < 32; i++) { // 32位整型数处理
            int mask = 1 << i; // 构造一个掩码，位数随循环增加而左移
            int cnt = 0; // 统计当前位上为1的个数
            for (int j = 0; j < nums.length; j++) { // 遍历数组中的每个数
                if ((nums[j] & mask) != 0) { // 如果当前位上为1
                    cnt++; // 统计加一
                }
            }
            if (cnt % 3 != 0) { // 如果当前位上统计个数不是3的倍数
                ret |= mask; // 将当前位上设置为1，利用位运算的或运算符
            }
        }
        return ret; // 返回结果
    }
}
