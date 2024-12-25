package com.client.algorithem.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hqz
 * @create 2024/9/28 21:07
 */
public class Test9 {

    public static void main(String[] args) {
        int[] arrs = new int[]{1, 9, 3, 8, 2};
        System.out.println(longestSubString(arrs));
    }

    /**
     * 数组的最长递增子序列，也要使用动态规划
     * @param num
     * @return
     */
    public static int longestSubString(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        int[] dp = new int[num.length];
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[i] > num[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
