import java.util.Stack;

public class LC84 {
    public int largestRectangleArea(int[] heights) {
        int res = -1;
        int[] nums = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            nums[i + 1] = heights[i];
        }
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] < nums[st.peek()]) {
                int mid = st.pop();
                int left = st.peek();
                int w = i - left - 1;
                int sum = w * nums[mid];
                res = sum > res ? sum : res;
            }
            st.push(i);
        }
        return res;
    }
}
