package com.client.algorithem.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hqz
 * @create 2024/9/27 17:39
 */
public class removeDups {

    public static void main(String[] args) {
        String s ="dBowNgxyPZXZXlBTMKFskExQEK\n" +
                "SoriEYVEzZDtnWWWoCEFAKUFYEOENgPaNplIPybEQrHmzKMPN";
        System.out.println(removeDuplicates(s));
    }

    /**
     * 最长不重复字符串子串
     * @param str
     * @return
     */
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        Set<String> ss = new HashSet<>();
        for (Character c : str.toCharArray()) {
            if (!ss.contains(String.valueOf(c))) {
                ss.add(String.valueOf(c));
                result.append(c);
            }
        }
        return result.toString();
    }
}
