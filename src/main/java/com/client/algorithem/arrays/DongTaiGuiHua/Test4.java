package com.client.algorithem.arrays.DongTaiGuiHua;

/**
 * @author hqz
 * @create 2024/10/20 09:50
 */
public class Test4 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0};
        int k = 1;
        System.out.println(smallestRange(nums, k));
    }

    /**
     * 最小差值 908
     */
    private static int smallestRange(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return Math.max(0, max - min - 2 * k);
    }
}
