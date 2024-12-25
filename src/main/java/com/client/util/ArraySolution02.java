package com.client.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 数组系列二
 *
 * @author hqz
 * @create 2023/9/7 12:46
 */
public class ArraySolution02 {

    /**
     * 15 三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // paixu
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else if (sum > 0) r--;
            }
        }
        return ans;
    }

    /**
     * 找出数组里最大的三个数
     *
     * @param sums
     * @return
     */
    public int[] calc(int[] sums) {
        if (sums.length == 3) {
            return sums;
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > first) {
                second = first;
                first = sums[i];
            } else if (sums[i] > second) {
                third = second;
                second = sums[i];
            } else if (sums[i] > third) {
                third = sums[i];
            }
        }
        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,3,2};
        int[] nums2 = new int[]{5,1,4,4};
        int[] nums3 = new int[]{};
        nums3 = new ArraySolution02().calc(nums);
        Arrays.stream(nums3).forEach(System.out::print);

        nums3 = new ArraySolution02().calc(nums2);
        Arrays.stream(nums3).forEach(System.out::print);
    }
}
