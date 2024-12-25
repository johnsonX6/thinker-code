package com.client.algorithem.arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hqz
 * @create 2024/9/25 16:33
 */
public class Test4 {

    public static void main(String[] args) {
        int[] num = new int[]{3,5,1,8,6,0};
        System.out.println(k(num, 1));
        int[] num2 = new int[]{3,5,7,1,3};
        System.out.println(degree(num2));
    }

    private static int min(int[] num) {
        int min = 0;
        for (int i = 0; i < num.length; i++) {
            min = Math.min(min, num[i]);
        }
        return min;
    }

    /**
     * 数组的第k大元素
     */
    private static int k(int[] num, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < num.length; i++) {
            que.offer(num[i]);
            if (que.size() > k) {
                que.poll();
            }
        }
        return que.peek() != null ? que.peek() : 0;
    }

    /**
     * 数组的度(哈希法)
     */
    private static int degree(int[] num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            if (map.containsKey(num[i])) {
                map.put(num[i], map.getOrDefault(num[i], 0) + 1);
            }else {
                map.put(num[i], 1);
            }
        }
        return map.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getValue).orElse(0);
    }
}
