package com.client.algorithem.arrays.tanxin;

import java.util.Arrays;

/**
 * @author hqz
 * @create 2024/10/18 18:16
 */
public class Test4 {
    public static void main(String[] args) {
        int[] a= new int[]{4,2,3};
        int[] b = new int[]{4,-2,3};
        System.out.println(kthQuFan(b, 1));
    }

    /**
     * 1005 k次取反后，数组和为最大值，返回这个值
     * @param nums
     * @param k
     * @return
     */
    private static int kthQuFan(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        Arrays.sort(nums);
        int sum = 0;
        if (k % 2 == 1) nums[0] = -nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
