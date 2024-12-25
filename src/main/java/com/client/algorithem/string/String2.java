package com.client.algorithem.string;

/**
 * @author hqz
 * @create 2024/9/28 22:44
 */
public class String2 {
    public static void main(String[] args) {
        String s = "aba";
        String t = "abaabc";
        System.out.println(kmp(s, t));
    }

    /**
     * 滑动窗口算法，模版串s，在字符串t中出现多少次
     * @param s
     * @param t
     * @return
     */
    private static int kmp(String s, String t) {
        int count = 0;
        for (int i = 0; i <= t.length() - s.length(); i++) {
            String window = t.substring(i, i + s.length());
            if (s.equals(window)) {
                count++;
            }
        }
        return count;
    }
}
