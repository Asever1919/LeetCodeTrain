import java.util.HashSet;
import java.util.Set;

public class LC202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSum(n);
        }
        return n == 1;
    }
    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int x = n % 10;
            sum += x * x;
            n = n / 10;
        }
        return sum;
    }
}
