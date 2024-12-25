package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/9/25 21:46
 */
public class Test7 {

    public static void main(String[] args) {

        int[] nums = new int[]{4, 6, 7, 1, 3, 9};
        mergeSort(nums);
        for (int i : nums) {
            System.out.println(i + " ");
        }
    }

    /**
     * 归并排序 时间复杂度为O（nlogn），将数组分为两边分别排序，最后再把两有序数组，合并到一起
     *
     * @param nums
     */
    private static void mergeSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int mid = nums.length / 2;
        int[] left = new int[mid];
        int[] right = new int[nums.length - mid];
        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, nums.length - mid);
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }

    private static void merge(int[] nums, int[] left, int[] right) {
        int i = 0, j = 0, count = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[count++] = left[i++];
            } else {
                nums[count++] = right[j++];
            }
        }
        while (j < right.length) {
            nums[count++] = right[j++];
        }
        while (i < left.length) {
            nums[count++] = left[i++];
        }
    }
}
