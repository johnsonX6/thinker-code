package com.client.util;

/**
 * 数组系列一
 * @author hqz
 * @create 2023/9/7 09:33
 */
class Solution {

    /**
     * 数组的平方和排序
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int left =0, right = nums.length -1;
        int[] res = new int[nums.length];
        for(int i=nums.length -1; i>=0;i--){
            if(nums[left]*nums[left] < nums[right]*nums[right]){
                res[i] = nums[right]*nums[right];
                right--;
            }else{
                res[i] = nums[left]*nums[left];
                left++;
            }
        }
        return res;
    }

    /**
     * 数组的二分查找
     * @param nums
     * @param target
     * @return
     */
    public int midSearch(int[] nums , int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-2, 0, 1, 1};
        nums= s.sortedSquares(nums);
        int mid = s.midSearch(nums, 1);
        System.out.println(mid);
//       for(int i: nums){
//           System.out.println(i);
//       }
    }
}
