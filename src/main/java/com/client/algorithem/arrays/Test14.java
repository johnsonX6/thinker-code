package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/10/13 12:49
 */
public class Test14 {

    public static void main(String[] args) {
        int[] num = new int[]{5,1,2,3,4};
        rotate(num, 1);
        for(int i: num){
            System.out.print(i+" ");
        }
    }

    /**
     * 翻转前k个元素 先将数组全部翻转 再翻转前k个元素 最后翻转k到剩下的
     * 4 3 2 1 5
     * 4 5 1 2 3
     * @param arr
     * @param k
     */
        public static void rotate(int[] arr, int k) {
            int n = arr.length;
            k %= n;
            reverse(arr, 0, n - 1);
            reverse(arr, 0, k - 1);
            reverse(arr, k, n - 1);
        }

        private static void reverse(int[] arr, int start, int end) {
            while (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
}
