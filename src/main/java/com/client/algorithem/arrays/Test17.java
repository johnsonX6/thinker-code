package com.client.algorithem.arrays;

import java.util.Arrays;

/**
 * @author hqz
 * @create 2024/10/14 22:06
 */
public class Test17 {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        getAverageAndMid(array);
    }

    /**
     * 计算前i+1个数的平均数和中位数
     * @param nums
     */
    private static void getAverageAndMid(int[] nums) {
        double[] res = new double[nums.length];
        double[] res1 = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int[] sub = Arrays.copyOfRange(nums, 0, i + 1);
            int sum = 0;
            for (int j = 0; j < sub.length; j++) {
                sum += sub[j];
            }
            double avg = (double) sum / (sub.length);
            res[i] = avg;
            System.out.println("前" + (i+1) + "个数平均数：" + res[i]);
            if (sub.length % 2 == 0) {
                res1[i] = (sub[sub.length / 2 - 1] + sub[sub.length / 2]) / 2.0;
            } else {
                res1[i] = sub[sub.length / 2];
            }
            System.out.println("前" + (i+1) + "个数中位数：" + res1[i]);
        }
    }
}
