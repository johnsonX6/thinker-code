package com.client.algorithem.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hqz
 * @create 2024/10/14 13:50
 */
public class Test15 {

    public static void main(String[] args) {
        int[] s = new int[]{1,4,9,10};
        Queue queue = k(s, 3);
        while (!queue.isEmpty()){
            System.out.print(queue.poll() + "");
        }
    }

    private static Queue k(int[] num, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < num.length; i++) {
            que.offer(num[i]);
            if (que.size() > k) {
                que.poll();
            }
        }
        return que;
    }

    private static int[] topK2(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
        }
        return new int[]{first, second, third};
    }
}
