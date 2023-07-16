import java.util.HashSet;
import java.util.Set;

public class LC349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 ||
                nums2 == null || nums2.length == 0) return new int[]{0};
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int n : nums2) {
            if (set.contains(n)) {
                resSet.add(n);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }
}
