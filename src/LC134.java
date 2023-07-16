public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int gapSum = 0;
        for (int i = 0; i < gas.length; i++) {
            int gap = gas[i] - cost[i];
            gapSum += gap;
            min = min > gapSum ? gapSum : min;
        }
        if (gapSum < 0) return -1;
        if (min > 0) return 0;
        for (int i = gas.length - 1; i >= 0; i--) {
            min += gas[i] - cost[i];
            if (min >= 0) return i;
        }
        return -1;
    }
}
