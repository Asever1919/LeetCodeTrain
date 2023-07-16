package coding;

public class LeeCode59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int startX = 0;
        int startY = 0;
        int loop = n / 2;
        int mid = n / 2;
        int offset = 1;
        int count = 1;
        int i, j;
        while (loop-- > 0) {
            i = startX;
            j = startY;
            for (j = startY; j < n - offset; j++) {
                res[i][j] = count++;
            }
            for (i = startY; i < n - offset; i++) {
                res[i][j] = count++;
            }
            for (; j > startY; j--) {
                res[i][j] = count++;
            }
            for (; i > startX; i--) {
                res[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
        }
        if (n % 2 == 1) res[mid][mid] = count;
        return res;
    }
}
