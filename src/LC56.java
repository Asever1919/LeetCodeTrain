import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (right >= intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
            } else {
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        res.add(new int[]{left, right});
        return res.toArray(new int[res.size()][]);
    }
}
