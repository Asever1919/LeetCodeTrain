

import java.util.HashMap;
import java.util.Map;

public class LC454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap();
        int res = 0;
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                int a = n1 + n2;
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
        }
        for (int n3 : nums3) {
            for (int n4 : nums4) {
                int b = n3 + n4;
                if (map.containsKey(-b)) {
                    res += map.get(b);
                }
            }
        }
        return res;
    }
}
