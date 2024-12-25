package com.client.algorithem.sort;

import java.util.Arrays;

/**
 * 数组排序
 *
 * @author hqz
 * @create 2023/8/9 18:11
 */
public class SortArray {


    public static void main(String[] args) {
        int[] nums = new int[]{12, 3, 5, 6, 9, 10};
        SortArray.selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 时间复杂度n*n，每次找比当前元素小的元素，并交换当前元素，最小的放到最前面
     *
     * @param nums
     */
    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            // 找到最小元素下标
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换两元素
            if (minIndex != i) {
                int tmp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = tmp;
            }
        }
    }


}
