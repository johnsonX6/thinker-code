package com.client.algorithem.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hqz
 * @create 2024/10/17 19:12
 */
public class String5 {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        List<String> res = getRes(3);
        for(String s: res){
            System.out.println(s);
        }
    }

    /**
     * 剑指offer 获取n的几种括号对组合形式，合法的所有括号
     * @param n
     * @return
     */
    private static List<String> getRes(int n){

        dfs(n, n,"");
        return res;
    }

    private static void dfs(int left, int right, String parenthes) {
        if (left == 0 && right == 0) {
            res.add(parenthes);
        }
        if (left > 0) {
            dfs(left - 1, right, parenthes + "(");
        }
        if (left < right) {
            dfs(left, right - 1, parenthes + ")");
        }
    }
}
