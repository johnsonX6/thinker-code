package com.client.algorithem.arrays.DongTaiGuiHua;

import java.util.Arrays;

/**
 * @author hqz
 * @create 2024/10/30 15:44
 */
public class Test5 {
    public static void main(String[] args) {
        int amount = 11;
        int[] mon = new int[]{1,2,3};
        System.out.println(exchange(mon, amount));
    }

    /**
     * 零钱兑换
     * @param nums 货币单位数组
     * @param amount 总金额
     *               dp[i] 表示凑成金额为n需要最少硬币个数
     * @return
     */
    private static int exchange(int[] nums, int amount) {
        if (nums == null) return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < nums.length; j++) {
                // 剩余钱>0
                if (i - nums[j] >= 0) {
                    dp[i] = Math.min( dp[i], dp[i - nums[j]] + 1);
                }
            }
        }
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}
