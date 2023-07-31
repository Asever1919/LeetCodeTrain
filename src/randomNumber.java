import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class randomNumber {
//    public static void main(String[] args) {
//        Random random = new Random();
//        int m = 5;
//        System.out.println(new Date(System.currentTimeMillis()));
//        System.out.println(new SimpleDateFormat("每日刷题:yyyy年MM月dd日E HH时mm分ss秒").format(new Date(System.currentTimeMillis())));
//        System.out.println("加油！小弟弟！");
//        for (int i = 0; i < m; i++) {
//            int n = random.nextInt(201);
//            System.out.println("LeetCode:第" + n + "道题");
//        }
//    }
    public static void main(String[] args) {
        int[] nums = {
                1,2,3,4,5,10,11,15,17,19,20,21,22,23,31,32,33,34,39,42,43,48,49,53,55,56,62,
                64,70,72,75,76,78,79,84,85,94,96,98,101,102,104,105,114,121,124,128,136,139,
                141,142,146,
        };
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println(new SimpleDateFormat("每日刷题:yyyy年MM月dd日E HH时mm分ss秒").format(new Date(System.currentTimeMillis())));
        System.out.println("加油！小弟弟！");
        Random random = new Random();
        int m = 5;
        for (int i = 0; i < m; i++) {
            int n = random.nextInt(201);
            System.out.println("LeetCode:第" + n + "道题");
        }
    }
}
