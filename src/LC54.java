import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;

        int offset = 1;
        int loop = Math.min(m, n) / 2;
        int mid = Math.min(m, n) / 2;

        int startX = 0;
        int startY = 0;

        int i, j;
        while (loop-- > 0) {
            i = startX;
            j = startY;

            for (; j < n - offset; j++) {
                res.add(matrix[i][j]);
            }
            for (; i < m - offset; i++) {
                res.add(matrix[i][j]);
            }

            for (; j > startY; j--) {
                res.add(matrix[i][j]);
            }

            for (; i > startX; i--) {
                res.add(matrix[i][j]);
            }

            startX++;
            startY++;
            offset++;
        }
        if (Math.min(m, n) % 2 == 1) {
            if (m > n) {
                for (int k = 0; k < m - n + 1; k++) {
                    res.add(matrix[mid + k][mid]);
                }
            } else {
                for (int k = 0; k < n - m + 1; k++) {
                    res.add(matrix[mid][mid + k]);
                }
            }
        }
        return res;
    }
}
