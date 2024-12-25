package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/9/30 09:27
 */
public class Test11 {

    public static void main(String[] args) {
        int[] a1 = new int[]{1, 4, 6, 7, 2};
        int[] a2 = new int[]{8, 3, 6, 7, 2};
        System.out.println(longestDupArr(a1, a2));
    }


    /**
     * 求最长重复子数组,
     * @param m
     * @param n
     * @return
     */
    private static int longestDupArr(int[] m, int[] n) {
        int ans = 0;
        int mm = m.length;
        int nn = n.length;
        int[][] dp = new int[mm + 1][nn + 1];
        for (int i = 1; i <= mm; i++) {
            for (int j = 1; j <= nn; j++) {
                if (m[i - 1] == n[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
