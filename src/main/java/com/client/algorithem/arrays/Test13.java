package com.client.algorithem.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hqz
 * @create 2024/10/10 12:52
 */
public class Test13 {

    public static void main(String[] args) {
        int n = 13;
        List<Integer> result = numSquares(n);
        System.out.println(result);
    }

    /**
     * 动态规划
     * 求等于这个数的完全平方数的元素个数
     * @param n
     * @return
     */
    public static List<Integer> numSquares(int n) {
        List<Integer>[] dp = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i - j * j].size() + 1 < dp[i].size() || dp[i].isEmpty()) {
                    dp[i] = new ArrayList<>(dp[i - j * j]);
                    dp[i].add(j);
                }
            }
        }
        return dp[n];
    }



}
