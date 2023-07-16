public class LC73 {
    public static void main(String[] args) {
        LC73 lc73 = new LC73();
        int[][] num = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1,3,1,5}};
        int[][] num0ne = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        lc73.setZeroes(num0ne);
    }
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int Mnum = -1;
        int Nnum = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][0] == 0) Mnum = 1;
                if (matrix[0][j] == 0) Nnum = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
                System.out.println(matrix[i][j]);
            }
        }
        System.out.println("----1------");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
        }
        System.out.println("----1------");
        System.out.println("====================");
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println("-----2-----");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
        }
        System.out.println("------2----");
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (Mnum == 1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (Nnum == 1) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        System.out.println("-----3-----");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(matrix[i][j]);
            }
        }
        System.out.println("------3----");
//        if (matrix[m - 1][n - 1] == 0) {
//            for (int j = 0; j < n; j++) {
//                matrix[m - 1][j] = 0;
//            }
//            for (int i = 0; i < m; i++) {
//                matrix[i][n - 1] = 0;
//            }
//        }
    }
}
