package com.client.algorithem.multithread;

/**
 * @author hqz
 * @create 2024/10/16 13:22
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadOrderControl {
    static AtomicInteger res = new AtomicInteger(1);

    public static void main(String[] args) {

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        CountDownLatch latch3 = new CountDownLatch(1);

        Thread threadA = new Thread(new Work(res, latch1, latch2));

        Thread threadB = new Thread(new Work1(res, latch2, latch3));

        Thread threadC = new Thread(new Work2(res, latch3, latch3));

        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class Work implements Runnable {
        AtomicInteger atomicInteger;
        CountDownLatch c1;
        CountDownLatch c2;

        public Work(AtomicInteger atomicInteger, CountDownLatch c1, CountDownLatch c2) {
            this.atomicInteger = atomicInteger;
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void run() {
            System.out.print("0");
            c2.countDown();
        }
    }


    static class Work1 implements Runnable {
        AtomicInteger atomicInteger;
        CountDownLatch c1;
        CountDownLatch c2;

        public Work1(AtomicInteger atomicInteger, CountDownLatch c1, CountDownLatch c2) {
            this.atomicInteger = atomicInteger;
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void run() {
            try {
                c1.await();
                System.out.print(atomicInteger.get());
                atomicInteger.incrementAndGet();
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    static class Work2 implements Runnable {
        AtomicInteger atomicInteger;
        CountDownLatch c1;
        CountDownLatch c2;

        public Work2(AtomicInteger atomicInteger, CountDownLatch c1, CountDownLatch c2) {
            this.atomicInteger = atomicInteger;
            this.c1 = c1;
            this.c2 = c2;
        }

        @Override
        public void run() {
            try {
                c1.await();
                System.out.print(atomicInteger.get());
                atomicInteger.incrementAndGet();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
