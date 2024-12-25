package com.client.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hqz
 * @create 2023/9/7 09:57
 */
public class HashTable01 {

    public int[] twoSum(int[] nums, int target){
        int[] res = new int[]{0,0};
        for(int i=0; i< nums.length;i++){
            for(int j=1;j< nums.length;j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1,4,5};
        int[] res = new int[]{};
        res = new HashTable01().twoSum(nums, 5);
       Arrays.stream(res).forEach(System.out::println);
    }
}
