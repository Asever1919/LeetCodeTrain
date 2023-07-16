package WeekExam;

public class LC6396 {
    // 数位dp，看灵神
    public int count(String num1, String num2, int min_sum, int max_sum) {
        int count = 0;
        int n1 = Integer.valueOf(num1);
        int n2 = Integer.valueOf(num2);
        while (n1 <= n2) {
            int temp = n1;
            int sum = digit_sum(n1);
            if (sum >= min_sum && sum <= max_sum) {
                count++;
            }
            n1 = temp;
            n1++;
        }
        return count % (10^9 + 7);
    }
    private int digit_sum(int x) {
        int sum = 0;
        while (x > 0) {
            int num = x % 10;
            sum += num;
            x = x / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int count = 0;
        int n1 = 6312;

        int n2 = 9456;
        while (n1 <= n2) {
            int temp = n1;
            int sum = 0;
            while (n1 > 0) {
                int num = n1 % 10;
                System.out.println(num);
                sum += num;
                System.out.println(sum);
                n1 = n1 / 10;
                System.out.println(n1);
                System.out.println("========");
            }
            if (sum >= 1 && sum <= 8) {
                count++;
            }
            System.out.println(count);
            n1 = temp;
            n1++;
            System.out.println(count % (10^9 + 7));
        }
    }
}
