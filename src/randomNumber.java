import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class randomNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int m = 5;
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new SimpleDateFormat("每日刷题:yyyy年MM月dd日E HH时mm分ss秒").format(new Date(System.currentTimeMillis())));
        System.out.println("加油！小弟弟！");
        for (int i = 0; i < m; i++) {
            int n = random.nextInt(201);
            System.out.println("LeetCode:第" + n + "道题");
        }
    }
}
