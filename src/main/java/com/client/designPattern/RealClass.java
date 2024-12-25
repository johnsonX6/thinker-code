package com.client.designPattern;

/**
 * @author hqz
 * @create 2024/10/31 20:15
 */
public class RealClass implements Subject{
    @Override
    public void request() {
        System.out.println("realClass");
    }
}
