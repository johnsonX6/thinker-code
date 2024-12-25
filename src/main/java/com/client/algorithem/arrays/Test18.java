package com.client.algorithem.arrays;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hqz
 * @create 2024/10/15 13:04
 */
public class Test18 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int[] n = findTwoSum(array, 4);
        for (int i : n) {
            System.out.println("i:" + i);
        }
    }

    private static int[] target(int[] nums, int k) {
        Map<Integer, Integer> data = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == k - nums[i]) {
                    data.put(i, j);
                }
            }
        }
        int[] res = new int[2];
        if (!CollectionUtils.isEmpty(data)) {
            int a = data.keySet().stream().findFirst().orElse(0);
            int b = data.values().stream().findFirst().orElse(0);
            res[0] = nums[a];
            res[1] = nums[b];
        }
        return res;
    }

    /**
     * 找到和为target的两个数
     * @param nums
     * @param target
     * @return
     */
    public static int[] findTwoSum(int[] nums, int target) {
        // 对数组进行排序
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null; // 如果没有找到符合条件的两个数，返回null
    }


}
