package com.client.algorithem.arrays;

import java.util.Scanner;

/**
 * @author hqz
 * @create 2024/9/28 21:42
 */
public class Test10 {

    /**
     * 数独问题 todo
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matrix=  new int[9][9];
        for(int i=0;i< 9;i++){
            for(int j=0;j<9;j++){
                matrix[i][j] = scan.nextInt();
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    // 根据行、列和 3x3 子矩阵中的现有数字来确定合适的填充数字
                    int[] possibleNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                    boolean[] usedNumbers = new boolean[10];
                    // 检查同一行已使用的数字
                    for (int k = 0; k < 9; k++) {
                        if (matrix[i][k] > 0) {
                            usedNumbers[matrix[i][k]] = true;
                        }
                    }
                    // 检查同一列已使用的数字
                    for (int k = 0; k < 9; k++) {
                        if (matrix[k][j] > 0) {
                            usedNumbers[matrix[k][j]] = true;
                        }
                    }
                    // 检查所在 3x3 子矩阵已使用的数字
                    int rowStart = i / 3 * 3;
                    int colStart = j / 3 * 3;
                    for (int k = rowStart; k < rowStart + 3; k++) {
                        for (int l = colStart; l < colStart + 3; l++) {
                            if (matrix[k][l] > 0) {
                                usedNumbers[matrix[k][l]] = true;
                            }
                        }
                    }
                    // 确定可用于填充的数字
                    for (int num : possibleNumbers) {
                        if (!usedNumbers[num]) {
                            matrix[i][j] = num;
                            break;
                        }
                    }
                }
            }
        }
        // 输出填充后的矩阵
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
