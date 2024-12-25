package com.client.algorithem.arrays;

import org.apache.commons.lang.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hqz
 * @create 2024/9/25 14:20
 */
public class Test1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 6, 7, 1};
//        int[] nums2 = removeDup(nums);
//        for(int i=0; i< nums2.length;i++){
//            System.out.print(nums2[i]+" ");
//        }
        int n = subArray(nums, 7);
        System.out.println(n);
    }

    /**
     * 数组去重
     *
     * @param nums
     * @return
     */
    private static int[] removeDup(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!res.contains(nums[i])) {
                res.add(nums[i]);
            }
        }
        int[] res1 = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            res1[i] = res.get(i);
        }
        return res1;
    }

    /**
     * 和为k的子数组
     *
     * @param nums
     * @param target
     * @return
     */
    private static int subArray(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


}
