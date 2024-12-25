package com.client.algorithem.multithread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hqz
 * @create 2024/10/16 15:16
 */
public class Test3 {
    /**
     * threadLocal使用
     */
    private static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Test3.set("a", "1");
        System.out.println(Test3.get("a"));
    }

    private static void set(String key, String val) {
        if (threadLocal.get() != null) {
            threadLocal.get().put(key, val);
        } else {
            Map<String, String> map = new HashMap<>();
            map.put(key,val);
            threadLocal.set(map);
        }
    }

    private static String get(String k) {
        if (threadLocal.get() != null) {
            return threadLocal.get().get(k);
        }
        return "";
    }
}
