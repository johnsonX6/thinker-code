package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/10/14 17:53
 */
public class Test16 {


    public static void main(String[] args) {
        char[][] nums = new char[][]{
                {'0', '0'}, {'1', '0', '0', '1'}
        };
        int n = calcLand(nums);
        System.out.println(n);
    }

    /**
     * 计算岛屿数量
     * @param nums
     * @return
     */
    private static int calcLand(char[][] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == '1') {
                    dfs(nums, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] nums, int i, int j) {
        if (i < 0 || j < 0 || i >= nums.length || j >= nums[i].length || nums[i][j] == '0') return;
        nums[i][j] = '0';
        dfs(nums, i + 1, j);
        dfs(nums, i, j + 1);
        dfs(nums, i - 1, j);
        dfs(nums, i, j - 1);
    }
}
