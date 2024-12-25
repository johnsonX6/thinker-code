package com.client.algorithem.arrays.matrix;

/**
 * @author hqz
 * @create 2024/10/30 16:09
 */
public class LuoXuanTest {
    public static void main(String[] args) {
        int[][] mat = new int[3][3];
        lxPrint(mat, 3);
    }

    /**
     * 从左到右 从上到上 从右到左 从下到上几个方向构建矩阵，且输出顺序递增
     * 输出结束判断条件为值小于数量
     * 1   2   3
     * 8   9   4
     * 7   6   5
     * @param matrix
     * @param n
     */
    private static void lxPrint(int[][] matrix, int n) {
        int rowS = 0;
        int rowE = n - 1;
        int colS = 0;
        int colE = n - 1;
        int idx = 1;
        while (idx <= n * n) {
            for (int i = colS; i <= colE; i++) {
                matrix[rowS][i] = idx++;
            }
            rowS++;
            for (int i = rowS; i <= rowE; i++) {
                matrix[i][colE] = idx++;
            }
            colE--;
            // 右到左
            if (rowS <= rowE) {
                for (int i = colE; i >= colS; i--) {
                    matrix[rowE][i] = idx++;
                }
                rowE--;
            }
            // 下到上
            if (colS <= colE) {
                for (int i = rowE; i >= rowS; i--) {
                    matrix[i][colS] = idx++;
                }
                colS++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
