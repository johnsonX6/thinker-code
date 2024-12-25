package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/10/17 22:57
 */
public class Test21 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,4,9,2,5};
        System.out.println(wiggleMaxLen(nums));
    }

    /**
     * 摆动序列 数组的后一个值与当前值的差值，满足一正一负，一负一正为摆动，如果仅有1个元素，空数组或只有2个元素也算
     * @param nums
     * @return
     */
    private static int wiggleMaxLen(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int curSum = 0;
        int preSum = 0;
        int len = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curSum = nums[i + 1] - nums[i];
            if ((preSum <= 0 && curSum > 0) || (preSum >= 0 && curSum < 0)) {
                len++;
                preSum = curSum;
            }
        }
        return len;
    }
}
