package com.client.util;

/**
 * 字符串类
 * @author hqz
 * @create 2023/9/7 21:15
 */
public class StringUtil {

    /**
     * 5 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for(int i=0;i < len;i++){
            for(int j=i+1;j<=len;j++){
                String test = s.substring(i, j);
                if(isHuiWen(test) && test.length() >= max){
                    ans = s.substring(i, j);
                    max = Math.max(ans.length(), max);
                }
            }
        }
        return ans;
    }

    public boolean isHuiWen(String s){
        for(int i=0 ; i< s.length();i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    /**
     * 647 统计回文子串的数量
     * @param s
     * @return
     */
    public int allSubString(String s){
        int count = 0;
        int len = s.length();
        for(int i=0;i < len;i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isHuiWen(test)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 392 判断子序列
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int p1= 0;
        int p2= 0;
        int len = s.length();
        while(p1 < len && p2 < t.length()){
            if(s.charAt(p1) == t.charAt(p2)){
                p1++;
            }
            p2++;
        }
        return p1 == len;
    }

    public static void main(String[] args) {

    }
}
