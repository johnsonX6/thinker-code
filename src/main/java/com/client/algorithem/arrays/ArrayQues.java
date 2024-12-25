package com.client.algorithem.arrays;

import com.sun.tools.javac.util.ArrayUtils;
import org.springframework.util.CollectionUtils;
import sun.security.util.ArrayUtil;

import java.util.*;

/**
 * @author hqz
 * @create 2024/8/1 10:17
 */
public class ArrayQues {

    /**
     * 数组反转
     *
     * @param args
     */
    public static void main(String[] args) {
//        int[] arrs = new int[]{1, 2, 3, 4, 5};
//        for (int i = 0; i < arrs.length / 2; i++) {
//            int tmp = arrs[i];
//            arrs[i] = arrs[arrs.length - 1 - i];
//            arrs[arrs.length - 1 - i] = tmp;
//        }
//        for (int i = 0; i < arrs.length; i++) {
//            System.out.println(arrs[i] + "");
//        }
        String s ="dBowNgxyPZXZXlBTMKFskExQEK\n" +
                "SoriEYVEzZDtnWWWoCEFAKUFYEOENgPaNplIPybEQrHmzKMPN";
        System.out.println(collectUniqueCharacters(s));

        System.out.println("==========");
        int[] nums = new int[]{3,5,6,1};
        List<List<Integer>> res = permute(nums);
        for(List<Integer> in: res){
            System.out.println(in);
        }

        int[] nums2 = new int[]{9,3,7,-1,8,0};
        int n = searchV2(nums2, 2);
        System.out.println(n);
    }

    /**
     * 二分搜索
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return target;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int searchV2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
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

    private static String collectUniqueCharacters(String input) {
        Set<Character> uniqueChars = new LinkedHashSet<>();
        Set<Character> seenChars = new HashSet<>();

        // 从后向前遍历字符串，收集唯一字符
        for (int i = input.length() - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            // 只添加未出现过的字符
            if (!seenChars.contains(currentChar)) {
                uniqueChars.add(currentChar);
                seenChars.add(currentChar);
            }
        }

        // 反转集合以恢复原有顺序
        StringBuilder result = new StringBuilder();
        for (Character ch : uniqueChars) {
            result.append(ch);
        }
        return result.reverse().toString();
    }
    /**
     * 全排列 数字不重复
     * @param res
     * @return
     */
    public static List<List<Integer>> permute(int[] res){
       List<List<Integer>> nums = new ArrayList<>();
       boolean[] used = new boolean[res.length];
       Arrays.fill(used, false);
       List<Integer> temps = new ArrayList<>();
       permuteHelper(nums, temps, res, used);
       return nums;
    }

    private static void permuteHelper(List<List<Integer>> nums, List<Integer> temps,int[] res, boolean[] used) {
       if(temps.size() == res.length){
           nums.add(new ArrayList<>(temps));
       }else {
           for (int i = 0; i < res.length; i++) {
               if(used[i]) {
                   continue;
               }
               temps.add(res[i]);
               used[i] = true;
               permuteHelper(nums, temps, res, used);
               temps.remove(temps.size() -1);
               used[i] = false;
           }
       }
    }


}
