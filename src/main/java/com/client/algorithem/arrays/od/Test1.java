package com.client.algorithem.arrays.od;

import java.util.Random;

/**
 * @author hqz
 * @create 2024/10/18 17:11
 */
public class Test1 {
    static String[] shousis = new String[]{"A","B","C","D"};
    public static void main(String[] args) {
        Random random = new Random();
        for(int i=0; i< shousis.length;i++){
            System.out.println("当前寿司："+ getShouSi(random));
        }
    }

    private static String getShouSi(Random random){
        int i = random.nextInt(shousis.length);
        return shousis[i];
    }
}
