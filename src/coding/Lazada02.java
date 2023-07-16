package coding;

import java.util.Scanner;

public class Lazada02 {
    public static void copy(int[][] pic, int[][] orgin, int x, int y) {
        for (int i = y; i < y + 3; i++){
            for (int j = x; j < x + 5; j++) {
                pic[i][j] = orgin[i - y][j - x];
            }
        }
    }
    public static void draw(int[][] pic, int[][] orgin, int x, int y, int depth) {
        if (depth == 1) {
            copy(pic, orgin, x, y);
        } else {
            int lenx = 5 * (1 << (depth - 1)) + (1 << (depth - 1)) - 1;
            int leny = 3 * (1 << (depth - 1));
            draw(pic, orgin, x + lenx / 4 + 1, y, depth - 1);
            draw(pic, orgin, x, y + leny / 2, depth - 1);
            draw(pic, orgin, x + lenx / 2, y + leny / 2, depth - 1);

        }
    }
    public static void print(int[][] pic, int lenx, int leny) {
        for (int i = 0; i < leny; i++) {
            for (int j = 0; j < lenx; j++) {
                if (pic[i][j] == 0) {
                    System.out.println(" ");
                } else {
                    System.out.println("*");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] orign = new int[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i == 0 && j == 2) || (i == 1 && j % 2 == 1) || i == 2 && j % 2 == 0) {
                    orign[i][j] = 1;
                } else {
                    orign[i][j] = 0;

                }
            }
        }
        int lenx = 5 * (1 << (n - 1)) + (1 << (n - 1)) - 1;
        int leny = 3 * (1 << (n - 1));
        int[][] pic = new int[leny][lenx];
        for (int i = 0; i < leny; i++) {
            for (int j = 0; j < lenx; j++) {
                pic[i][j] = 0;
            }
        }
        draw(pic, orign, 0, 0, n);
        print(pic, lenx, leny);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lenx / 2; j++) {
                System.out.println(" ");
            }
            System.out.println("*");
        }
    }

}
