package com.client.collection;

import java.util.TreeMap;

/**
 * @author hqz
 * @create 2024/10/31 19:51
 */
public class Test1 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(0, 1);
        System.out.println(treeMap);
    }

}
