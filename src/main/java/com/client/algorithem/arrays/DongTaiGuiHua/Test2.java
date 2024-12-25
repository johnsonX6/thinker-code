package com.client.algorithem.arrays.DongTaiGuiHua;

/**
 * @author hqz
 * @create 2024/10/19 13:36
 */
public class Test2 {

    public static void main(String[] args) {
        int n = 13;
        System.out.println(sqrt(n));
    }

    /**
     * 和为完全平方数的最小元素个数
     *
     */
    private static int sqrt(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
