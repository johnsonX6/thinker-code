package com.client.algorithem.string;

import com.client.util.StringUtil;
import org.apache.commons.lang.StringUtils;

/**
 * @author hqz
 * @create 2024/10/8 15:46
 */
public class String3 {

    public static void main(String[] args) {
        String s = "abba";
        String s1 = "abcbac";
        System.out.println(isHuiWen(s1));
    }

    public static boolean isHuiWen(String s){
        if(StringUtils.isEmpty(s)){
            return false;
        }
        char[] ch =  s.toCharArray();
        for(int i=0;i< ch.length/2;i++){
            if(ch[i] != ch[ch.length -1-i]){
                return false;
            }
        }
        return true;
    }
}
