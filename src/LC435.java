import java.util.Arrays;

public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] <= intervals[i][0]) {
                count++;
            } else {
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return intervals.length - count;
    }
}
