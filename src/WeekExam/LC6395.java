package WeekExam;

import java.util.Arrays;

public class LC6395 {
    public int buyChoco(int[] prices, int money) {
        if (prices.length <= 1) return money;
        Arrays.sort(prices);
        if (prices[0] >= money) return money;
        if (prices[0] + prices[1] > money) {
            return money;
        } else {
            return money - (prices[0] + prices[1]);
        }
    }
}
