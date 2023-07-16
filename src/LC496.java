import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        st.push(0);
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                if (map.containsKey(nums2[st.peek()])) {
                    int index = map.get(nums2[st.peek()]);
                    res[index] = nums2[i];
                }
                st.pop();
            }
            st.push(i);
        }
        return res;
    }
}
