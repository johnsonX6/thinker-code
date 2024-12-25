package com.client.algorithem.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hqz
 * @create 2024/9/25 16:00
 */
public class Test3 {

    public static void main(String[] args) {
        int[] res = new int[]{1, 2, 6, 0, 8, 0};
//        res = move0(res);
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i]);
//        }
//        int[] res1 = move00(res);
//        for (int i = 0; i < res1.length; i++) {
//            System.out.print(res1[i] + " ");
//        }

        System.out.println(peek(res));
    }

    /**
     * 移动0
     *
     * @param nums
     * @return
     */
    private static int[] move0(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        for (int j = list.size(); j < n; j++) {
            res[j] = 0;
        }
        return res;
    }

    private static int[] move00(int[] sum) {
        int n = sum.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] != 0) {
                sum[j++] = sum[i];
            }
        }
        for (int i = j; i < n; i++) {
            sum[i] = 0;
        }
        return sum;
    }

    /**
     * 寻找数组峰值
     *
     * @param sum
     * @return
     */
    private static int peek(int[] sum) {
        int n = sum.length;
        for (int i = 0; i < sum.length; i++) {
            boolean ok = true;
            if (i - 1 > 0) {
                if (sum[i] <= sum[i - 1]) ok = false;
            }
            if (i + 1 < n) {
                if (sum[i] <= sum[i + 1]) ok = false;
            }
            if (ok) {
                return i;
            }
        }
        return -1;
    }
}
