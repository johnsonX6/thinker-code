package com.client.algorithem.arrays.DongTaiGuiHua;

/**
 * @author hqz
 * @create 2024/10/20 09:39
 */
public class Test3 {

    public static void main(String[] args) {
        System.out.println(3);
    }

    /**
     * 爬楼梯 70
     * @param nums
     * @return
     */
    private static int climbStairs(int[] nums){
        int[] dp = new int[nums.length+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=nums.length;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[nums.length];
    }
}
