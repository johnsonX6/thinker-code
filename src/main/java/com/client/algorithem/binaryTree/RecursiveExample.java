package com.client.algorithem.binaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hqz
 * @create 2024/9/10 22:25
 */
public class RecursiveExample {
    private static int counter = 0;

    public static void recursiveMethod(int depth) {
        System.out.println("Depth: " + depth + " Counter: " + counter);
        counter++;

        if (depth < 10) {
            recursiveMethod(depth + 1); // 递归调用
        }

        System.out.println("Back to Depth: " + depth + " Counter: " + counter);
        counter++;
    }

    enum A{
        a, b,c;
        private A(){
            System.out.println("saaa");
        }
    }

    public static void main(String[] args) {
        recursiveMethod(0);
//        Scanner in = new Scanner(System.in);
//        String a = in.nextLine();
//        String b = in.nextLine();
//        String[] b1 = b.split(" ");
//        long[] nums = new long[b1.length];
//        Map<Long,Integer> maps = new HashMap<>();
//        for(int i=0 ;i< b1.length; i++){
//            nums[i] = Long.parseLong(b1[i]);
//        }
//        for(int i=0,j=i+1;i< nums.length;i++){
//            long n = nums[i];
//            if(nums[j] == n){
//                maps.put(n, maps.getOrDefault(n, 0)+1);
//            }
//        }
        System.out.println(A.a);
    }
}
