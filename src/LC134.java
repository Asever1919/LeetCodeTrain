public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int curSum = 0;
        for (int i = 0; i < gas.length; i++) {
            int gap = gas[i] - cost[i];
            curSum += gap;
            if (curSum < 0) return -1;
            min = Math.min(min, gap);
        }
        if (min >= 0) return 0;
        for (int i = gas.length - 1; i >= 0; i--) {
            min += (gas[i] - cost[i]);
            if (min >= 0) return i;
        }
        return -1;
    }
}
