package com.client.algorithem.string;

/**
 * @author hqz
 * @create 2024/10/17 19:10
 */
public class String4 {
    public static void main(String[] args) {
        String s ="()";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s){
        for(int i=0;i< s.length();i++){
            s = s.replace("()", "").replace("{}","").replace("[]", "");
        }
        return s.length() == 0;
    }
}
