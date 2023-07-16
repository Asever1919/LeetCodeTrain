package coding;

import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.Stack;

public class JinShanYun {
    public boolean traversal (TreeNode root) {
        if (root == null) return false;
        return false;
    }
    public static void main(String[] args) {
//        String input = "Who are are ARE ArE you".toLowerCase();
//        String[] words = input.split(" ");
//        StringBuilder sb = new StringBuilder(words[0]);
//        for (int i = 1; i < words.length; i++) {
//            if (!words[i].equals(words[i - 1])) {
//                System.out.println(sb.toString());
//                sb.append(" ");
//                sb.append(words[i]);
//            }
//        }
//        System.out.println(sb.toString());
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine().toLowerCase();
//        String[] words = input.split("").;
//        StringBuilder sb = new StringBuilder(words[0]);
//        for (int i = 1; i < words.length; i++) {
//            if (!words[i].equals(words[i - 1])) {
//                sb.append(" ");
//                sb.append(words[i]);
//            }
//        }
//        System.out.println(sb.toString());
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        for (int i = 0; i < len; i++) {
            int n = input.nextInt();
            int[] weight = new int[n];
            for (int j = 0; j < n; j++) {
                weight[j] = input.nextInt();
            }
            boolean flag = false;
            for (int k = 0; k < n; k++) {
                if (2 * k + 1 < n) {
                    int left = 0;
                    int right = 0;
                    for (int m = 2 * k + 1; m <= Math.min(2 * k + 2, n - 1); m++) {
                        if (m < 2 * k + 2) {
                            left += weight[m];
                        } else {
                            right += weight[m];
                        }
                    }
                    if (left == right) {
                        System.out.println("Yes");
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                System.out.println("No");
            }
        }

    }


}
