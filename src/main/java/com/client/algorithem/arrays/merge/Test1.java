package com.client.algorithem.arrays.merge;

/**
 * @author hqz
 * @create 2024/10/20 11:03
 */
public class Test1 {

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,3,0,0,0};
        int[] nums1 = new int[]{-1,0,1};
        merge(nums,3, nums1,3);
    }

    /**
     * 合并有序数组到原数组
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        int i=m-1;
        int j=n-1;
        int idx=m+n-1;
        while(i>=0 && j>=0){

            if(A[i] < B[j]){
                A[idx--] = B[j--];
            }else{
                A[idx--] = A[i--];
            }
        }
        // 如果b数组值一直比较小 j指针没变，需要倒叙移动给i指针
        while(j>=0) A[idx--] = B[j--];
    }
}
