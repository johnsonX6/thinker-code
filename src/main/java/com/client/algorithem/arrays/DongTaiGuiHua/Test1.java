package com.client.algorithem.arrays.DongTaiGuiHua;

/**
 * @author hqz
 * @create 2024/10/16 21:22
 */
public class Test1 {
    public static void main(String[] args) {
        int[] weights = new int[]{2, 3, 4, 5};
        int[] vals = new int[]{3, 4, 5, 6};
        int cap = 8;
        System.out.println(bag(weights, vals, cap));
    }

    /**
     * 每个物品的重量，每个物品的价值，背包的容量
     * dp[i][j]表示物品i放入容量为j的背包的最大价值
     *
     * @param weights
     * @param values
     * @param capacity
     * @return
     */
    private static int bag(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }
        return dp[n][capacity];
    }


}
