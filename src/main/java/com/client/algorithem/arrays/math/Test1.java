package com.client.algorithem.arrays.math;

/**
 * @author hqz
 * @create 2024/10/20 12:25
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(getMax(10, 10));
    }

    /**
     * 比较两个数大小，不能用运算符；
     * 利用无符号右移 负数运算完返回1，大于等于0返回0
     * @param a
     * @param b
     * @return
     */
    private static int getMax(int a, int b) {
        long r = (long) a - (long) b;
        int[] res = new int[]{a, b};
        return res[(int) (r >>> 63)];
    }
}
