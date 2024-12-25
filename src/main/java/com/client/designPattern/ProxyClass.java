package com.client.designPattern;

/**
 * @author hqz
 * @create 2024/10/31 20:16
 */
public class ProxyClass implements Subject {
    RealClass realClass;

    public ProxyClass(RealClass realClass) {
        this.realClass = realClass;
    }

    /**
     * 拦截执行前，执行后执行某些操作
     */
    @Override
    public void request() {
        System.out.println("proxyClass-before");
        realClass.request();
        System.out.println("proxyClass-after");
    }

    public static void main(String[] args) {
        RealClass realClass = new RealClass();
        ProxyClass proxyClass = new ProxyClass(realClass);
        proxyClass.request();
    }
}
