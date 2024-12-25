package com.client.algorithem.arrays;

import java.util.Arrays;

/**
 * @author hqz
 * @create 2024/10/31 21:19
 */
public class Test24 {

    public static void main(String[] args) {
        String a = "243512102456";
        System.out.println(maxIncr(a));
    }

    /**
     * 最长递增子序列
     * @param a
     * @return
     */
    private static int maxIncr(String a) {
        int[] dp = new int[a.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) > a.charAt(i - 1)) {
                dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
