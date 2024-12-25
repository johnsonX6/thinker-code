package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/10/8 16:07
 */
public class Test12 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,9,12,4,0};
        System.out.println(twoSum(nums, 22));
    }

    private static int twoSum(int[] num, int target) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            int sum = 0;
            for (int j = i; j < num.length; j++) {
                sum += num[j];
                if (sum == target) {
                    count++;
                }
            }
        }
        return count;
    }

}
