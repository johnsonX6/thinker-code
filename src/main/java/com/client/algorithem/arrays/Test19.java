package com.client.algorithem.arrays;


/**
 * @author hqz
 * @create 2024/10/17 09:23
 */
public class Test19 {
    public static void main(String[] args) {
        String s = "1234c4321";
        System.out.println(longestPalim(s));
    }

    /**
     * 输出最长回文字符子串
     * @param s
     * @return
     */
    private static String longestPalim(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String res = null;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String tmp = s.substring(i, j);
                if (isHuiWen(tmp) && tmp.length() >= max) {
                    max = tmp.length();
                    res = tmp;
                }
            }
        }
        return res;
    }

    private static boolean isHuiWen(String s) {
        if(s== null || s.length() == 0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }


}
