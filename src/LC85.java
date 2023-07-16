import java.util.Stack;

public class LC85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            int max = largestRectangleArea(height);
            res = res > max ? res : max;
        }
        return res;
    }
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
