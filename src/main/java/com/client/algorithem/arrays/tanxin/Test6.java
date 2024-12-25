package com.client.algorithem.arrays.tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hqz
 * @create 2024/10/30 16:49
 */
public class Test6 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4};
        System.out.println(permuteV1(nums));
    }

    /**
     * 求数字的全排列 如给3，4，5输出[[3, 5, 4], [3, 4, 5], [5, 3, 4], [5, 4, 3], [4, 3, 5], [4, 5, 3]]
     * @param nums
     * @return
     */
    private static List<List<Integer>> permuteV1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        List<Integer> tmp = new ArrayList<>();
        permuteSub(res, flags, tmp, nums);
        return res;
    }

    private static void permuteSub(List<List<Integer>> res, boolean[] flags, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (flags[i]) {
                    continue;
                }
                tmp.add(nums[i]);
                flags[i] = true;
                permuteSub(res, flags, tmp, nums);
                flags[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
