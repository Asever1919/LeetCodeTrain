import java.util.ArrayList;
import java.util.List;

public class LC57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 用链表来存储结果
        List<int[]> res = new ArrayList<>();

        // 因现有数组为有序数组，因此寻找插入位置
        // 判定条件就是，当前区间右边界小于newInterval的左边界。
        int idx = 0;
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            res.add(intervals[idx]);
            idx++;
        }
        // 合并区间
        // 当前区间的左边界要小于等于插入newInterval的右边界
        // idx全篇都是小于长度
        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[idx][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[idx][1], newInterval[1]);
            idx++;
        }
        res.add(newInterval);
        // 将后面的区间插入进去
        while (idx < intervals.length) {
            res.add(intervals[idx++]);
        }
        return res.toArray(new int[res.size()][0]);
    }
}
