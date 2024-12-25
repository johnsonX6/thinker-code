package com.client.algorithem;

import java.util.PriorityQueue;

/**
 * @author hqz
 * @create 2024/11/2 15:00
 */
public class Test1102 {
    public static void main(String[] args) {
//        int[] nums = new int[]{9,-1,8,2};
//        System.out.println(getK(nums, 3));
        int n= Integer.valueOf("001");
        System.out.println(n);
    }

    /**
     * 求第k大元素
     * @param nums
     * @param k
     * @return
     */
    private static int getK(int[] nums, int k) {
        if (nums == null || nums.length <= k) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
