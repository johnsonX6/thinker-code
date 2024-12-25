package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/9/25 17:42
 */
public class Test6 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 7, 0};
        System.out.println(gupiao(nums));
    }

    private static int gupiao(int[] nums) {
        int price = nums[0];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - price);
            price = Math.min(price, nums[i]);
        }
        return ans;
    }

    /**
     * 含利润 todo
     */
    private static int gupiaoprofit(int[] nums){
        return 0;
    }
}
