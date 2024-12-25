package com.client.algorithem.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hqz
 * @create 2024/10/19 17:18
 */
public class Test5 {

    /**
     * 线程池单线程方式保证顺序执行
     */
    private static ExecutorService executorService = Executors.newFixedThreadPool(1);
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        exec();
        executorService.shutdown();
    }

    private static void exec() {
        for (int i = 0; i < 4; i++) {
            executorService.submit(new Thread(new Work()));
            executorService.submit(new Thread(new Work1(atomicInteger)));
            executorService.submit(new Thread(new Work()));
            executorService.submit(new Thread(new Work2(atomicInteger)));
        }
    }


    static class Work implements Runnable {
        @Override
        public void run() {
            System.out.print("0");
        }
    }


    static class Work1 implements Runnable {
        AtomicInteger atomicInteger;

        public Work1(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            System.out.print(atomicInteger.get());
            atomicInteger.incrementAndGet();
        }
    }


    static class Work2 implements Runnable {
        AtomicInteger atomicInteger;

        public Work2(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            System.out.print(atomicInteger.get());
            atomicInteger.incrementAndGet();
        }
    }
}
