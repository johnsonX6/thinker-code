package com.client.algorithem.multithread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hqz
 * @create 2024/10/16 14:15
 */
public class Test1 {
    /**
     * abacabacabac顺序执行 阻塞队列方式
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingDeque<Thread> linkedBlockingDeque = new LinkedBlockingDeque();
        AtomicInteger atomicInteger = new AtomicInteger(1);
        int n = 3;
        for (int i = 0; i < n; i++) {
            linkedBlockingDeque.add(new Thread(new Work()));
            linkedBlockingDeque.add(new Thread(new Work1(atomicInteger)));
            linkedBlockingDeque.add(new Thread(new Work()));
            linkedBlockingDeque.add(new Thread(new Work2(atomicInteger)));
        }


        for (int i = 0; i < 4*n; i++) {
            Thread t = linkedBlockingDeque.take();
            t.start();
            while (t.isAlive());
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
