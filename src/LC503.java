import java.util.Arrays;
import java.util.Stack;

public class LC503 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length <= 1) return new int[]{-1};
        int len = nums.length;
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 0; i < 2 * len; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i % len]) {
                res[st.peek()] = nums[i % len];
                st.pop();
            }
            st.push(i % len);
        }
        return res;
    }
}
