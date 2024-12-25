package com.client.algorithem.limiter;

import java.util.concurrent.TimeUnit;

/**
 * @author hqz
 * @create 2024/12/4 21:58
 */
public class CustomRateLimiter {
    private double permitsPersecond;
    private double storedPermits;
    private long nextTicketsMicro = 0;

    public CustomRateLimiter(double permitsPersecond){
        this.permitsPersecond = permitsPersecond;
    }

    public synchronized boolean tryAcquire() {
        long nowMicro = TimeUnit.MICROSECONDS.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        // 计算新的令牌桶
        if (nextTicketsMicro <= nowMicro) {
            double newPermits = (nowMicro - nextTicketsMicro) * permitsPersecond / TimeUnit.MICROSECONDS.convert(1, TimeUnit.SECONDS);
            storedPermits = Math.min(storedPermits + newPermits, permitsPersecond);
            nextTicketsMicro = nowMicro;
        }
        if (storedPermits > 0) {
            storedPermits -= 1.0;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        CustomRateLimiter rateLimiter = new CustomRateLimiter(2.0); // 每秒允许2个请求通过
        for(int i=0;i< 10;i++) {
            if (rateLimiter.tryAcquire()) {
                System.out.println(i);
            } else {
                System.out.println("限流了" + i);
            }
            Thread.sleep(300);
        }
    }
}
