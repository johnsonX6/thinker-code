package com.client.algorithem.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hqz
 * @create 2024/10/18 16:42
 */
public class Test22 {
    public static void main(String[] args) {
        int[] ans = new int[]{-1,0,1,2,0,4};
//        System.out.println(threeSum(ans));
//        System.out.println(twoSum(ans));
        int[] ans1 = new int[]{-1,0,1,2,0,4,4,0};
        System.out.println(Arrays.toString(removeDup(ans1)));
    }

    /**
     * 三数之和 计算三数之和为0的子集合
     */
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) return ans;
        int l = 0;
        int r = nums.length - 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }

    private static List<List<Integer>> twoSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 2) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[j]));
                }
            }
        }
        return ans;
    }

    private static int[] removeDup(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            if (!res.contains(i)) {
                res.add(i);
            }
        }
        int[] n = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            n[i] = res.get(i);
        }
        return n;
    }
}
