package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/10/31 08:20
 */
public class Test23 {
    public static void main(String[] args) {
        int[] nums = new int[]{6,1,4,9,10};
        System.out.println(maxProfit(nums));
    }

    private static int maxProfit(int[] nums){
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0;i< nums.length;i++){
            profit = Math.max(profit, nums[i] - min);
            min = Math.min(nums[i], min);
        }
        return profit;
    }

    /**
     * 可以多次买卖 求累计最大利润，最多只能持一股，也可当天买 当天卖
     * @param nums
     * @return
     */
    private static int maxProfitV2(int[] nums){
        int profit = 0;
        for(int i=1;i< nums.length;i++){
            int tmp = nums[i] - nums[i-1];
            if(tmp > 0) profit+=tmp;
        }
        return profit;
    }
}
