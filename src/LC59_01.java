public class LC59_01 {
    public int[][] generateMatrix(int n) {
        // 定义一些变量：起始位置、圈数、每次减边的条书，中心位置mid；
        int loop = n / 2;
        int mid = n / 2;
        int offset = 1;
        int startX = 0;
        int startY = 0;
        int[][] matrix = new int[n][n];
        int count = 1;

        while (loop-- > 0) {
            int i = startX;
            int j = startY;
            for (; i < n - offset; i++) {
                matrix[j][i] = count++;
            }
            for (; j < n - offset; j++) {
                matrix[j][i] = count++;
            }
            for (i = n - offset; i > startX; i--) {
                matrix[j][i] = count++;
            }
            for (j = n - offset; j > startY; j--) {
                matrix[j][i] = count++;
            }
            startX++;
            startY++;
            offset++;
        }
        if (n % 2 == 1) matrix[mid][mid] = count;
        return matrix;
    }
}
