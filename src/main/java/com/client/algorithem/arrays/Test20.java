package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/10/17 10:11
 */
public class Test20 {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(profit(prices));
        System.out.println(profitV2(prices));
    }

    /**
     * 当天买，可当天卖，最大利润，最多只能持一股
     * @param prices
     * @return
     */
    private static int profit(int[] prices){
        int profit = 0;
        for(int i=1;i< prices.length;i++){
            int tmp = prices[i] - prices[i-1];
            if(tmp> 0) profit+= tmp;
        }
        return profit;
    }

    /**
     * 当天买，在未来的某天卖，最大利润
     * @param prices
     * @return
     */
    private static int profitV2(int[] prices){
        int profit = 0;
        int min =Integer.MAX_VALUE;
        for(int i=0;i< prices.length;i++){
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return profit;
    }
}
