package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/9/27 15:56
 */
public class Test8 {

    public static void main(String[] args) {
        int[] nums = new int[]{9,7,3,6,10,2,8};
        mergeSort(nums);
        for(int i: nums){
            System.out.print(i+" ");
        }
    }


    /**
     * 归并排序
     * @param nums
     */
    private static void mergeSort(int[] nums){
        if(nums == null || nums.length <= 1){
            return;
        }
        int mid = nums.length/2;
        int[] left = new int[mid];
        int[] right = new int[nums.length- mid];
        System.arraycopy(nums, 0,left, 0, mid);
        System.arraycopy(nums, mid,right, 0, nums.length - mid);
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
        while (i < left.length) {
            nums[count++] = left[i++];
        }
        while (j < right.length) {
            nums[count++] = right[j++];
        }
    }
}
