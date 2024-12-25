package com.client.algorithem.arrays.yunsuan;

/**
 * @author hqz
 * @create 2024/10/17 10:27
 */
public class Test1 {
    public static void main(String[] args) {
        int[] r = new int[]{2, 2, 1};
        System.out.println(get1(r));
    }

    /**
     * 求相同次数为1的值
     * 异或是相同为0，不同为1，其余两个数都为1，这样异或最后的就是需要的值
     *
     * @param nums
     * @return
     */
    private static int get1(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
