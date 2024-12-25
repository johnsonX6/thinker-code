package com.client.algorithem.multithread;

/**
 * @author hqz
 * 单例模式-双重校验
 * @create 2024/10/31 19:44
 */
public class Test7 {

    // 防止指令重排
    volatile static Test7 test7;
    // 私有构造
    private Test7(){

    }

    public static void main(String[] args) {

    }

    /**
     * 二次加载获取单例实例
     * @return
     */
    private static Test7 getInstance() {
        if (test7 == null) {
            synchronized (Test7.class) {
                if(test7 == null) {
                    test7 = new Test7();
                }
            }
        }
        return test7;
    }
}
