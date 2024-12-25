package com.client.algorithem;

import com.client.util.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hqz
 * @create 2024/11/6 16:14
 */
public class Test1103 {

    public static void main(String[] args) {
        String s= "abcdaes";
        System.out.println(longestSubStr(s));
        String s1 = "abcdesbaq";
        System.out.println(longestSubStr(s1));
        String s2="145820";
        System.out.println(longestIncrStr(s2));
        System.out.println( StringUtils.reverse(s2));

        int[] nums = new int[]{1,1,1,3,3,2};
        System.out.println(removeDup1(nums));
    }

    private static int longestSubStr(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, len = 0;
        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.getOrDefault(s.charAt(r), 0), l);
            } else {
                map.put(s.charAt(r), r);
            }
            len = Math.max(len, r - l);
        }
        return len;
    }

    /**
     * 最长递增子序列 需要拿dp【j】比较
     * @param s
     * @return
     */
    private static int longestIncrStr(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) > s.charAt(j)) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    private static int removeDup(int[] nums){
        int j=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i] != nums[j]){
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

    /**
     * 重复次数超过两次的元素只出现两次，返回新数组长度
     * @param nums
     * @return
     */
    private static int removeDup1(int[] nums){
        int count = 2;
        for(int i=0;i< nums.length;i++){
            if(nums[i] != nums[count -2]){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
