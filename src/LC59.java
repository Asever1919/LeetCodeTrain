public class LC59 {
    public static void main(String[] args) {
        int n = 4;

        int[][] res = new int[n][n];
        int startx = 0;
        int starty = 0;
        int loop = n / 2;
        int mid = n / 2;
        int count = 1;
        int offset = 1;
        int i, j;
        while (loop-- > 0) {
            i = startx;
            j = starty;
            for (j = starty; j < n - offset; j++) {
                System.out.println(count);
                res[i][j] = count++;

            }
            for (i = startx; i < n - offset; i++) {
                System.out.println(count);
                res[i][j] = count++;

            }
            for (j = n - offset; j > 0; j--) {
                System.out.println(count);
                res[i][j] = count++;

            }
            for (i = n - offset; i > 0; i--) {

                System.out.println(count);
                res[i][j] = count++;

            }
            startx++;
            starty++;
            offset++;
        }
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
    }
}
