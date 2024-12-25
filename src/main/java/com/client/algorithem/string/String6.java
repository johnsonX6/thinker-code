package com.client.algorithem.string;

import java.util.Arrays;

/**
 * @author hqz
 * @create 2024/10/19 13:59
 */
public class String6 {
    public static void main(String[] args) {
        String a="8914560313";
        System.out.println(longestMoreStr1(a));
    }

    /**
     * 错误写法
     * @param a
     * @return
     */
    private static String longestMoreStr(String a) {
        if (a.isEmpty()) {
            return "";
        }
        int max = 0;
        String s = "";
        for (int i = 0; i < a.length(); i++) {
            int a1 = Integer.parseInt(a.charAt(i) + "");
            for (int j = i + 1; j < a.length(); j++) {
                int subLen = j - i - 1;
                if (Integer.parseInt(a.charAt(j) + "") > a1 && subLen > max) {
                    max = subLen;
                    s = a.substring(i, j);
                }
            }
        }
        return s;
    }

    /**
     * 最长递增子序列
     * @param a
     * @return
     */
    private static int longestMoreStr1(String a) {
        int[] dp = new int[a.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < a.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (a.charAt(i) > a.charAt(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLen = 0;
        for (int i = 0; i < dp.length; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
