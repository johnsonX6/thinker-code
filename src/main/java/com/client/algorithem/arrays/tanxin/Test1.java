package com.client.algorithem.arrays.tanxin;

import java.util.Arrays;

/**
 * @author hqz
 * @create 2024/10/16 23:04
 */
public class Test1 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{1, 1};
        System.out.println("a:" + fenFa(a, b));
    }

    /**
     * 455 分发糖果 g为小孩的胃口大小数组 s为饼干的大小数组，保证更多的小孩吃到饼干，且饼干不小于小孩胃口
     * @param g
     * @param s
     * @return
     */
    private static int fenFa(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] > s[j]) {
                j++;
            } else {
                i++;
                j++;
                count++;
            }
        }
        return count;
    }
}
