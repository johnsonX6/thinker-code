package com.client.algorithem.string;

/**
 * @author hqz
 * @create 2024/10/20 18:45
 */
public class String7 {

    public static void main(String[] args) {
        String a = "aaaabbc";
        System.out.println(compress(a));
    }

    private static String compress(String S){
        int count, i=0,len = S.length();
        StringBuilder sb = new StringBuilder();
        while(i< len){
            char cur = S.charAt(i);
            count =1;
            while(i< len -1 && cur == S.charAt(i+1)){
                i++;
                count++;
            }
            i++;
            sb.append(cur).append(count);
        }
        return sb.length()< len? sb.toString() : S;
    }
}
