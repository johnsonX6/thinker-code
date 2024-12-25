package com.client.algorithem.multithread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hqz
 * @create 2024/10/19 17:30
 */
public class Test6 {
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        for(int i=0; i< 2;i++) {
            Thread t = new Thread(new Work(null)); // 0
            Thread t1 = new Thread(new Work1(t)); // 1
            Thread t2 = new Thread(new Work(t1)); // 0
            Thread t3 = new Thread(new Work2(t2)); // 2
            t.start();
            t1.start();
            t2.start();
            t3.start();
        }
    }

    /**
     * join方式保证按顺序执行
     */
    private static void execWithJoin(){

    }

    static class Work implements Runnable{
        Thread t;
        public Work(Thread t){
            this.t = t;
        }

        @Override
        public void run() {
            if(t!= null){
                try {
                    t.join();
                    System.out.print(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.print(0);
            }
        }
    }

    static class Work1 implements Runnable{
        Thread t;
        public Work1(Thread t){
            this.t = t;
        }

        @Override
        public void run() {
            if(t!= null){
                try {
                    t.join();
                    System.out.print(atomicInteger.get());
                    atomicInteger.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class Work2 implements Runnable{
        Thread t;
        public Work2(Thread t){
            this.t = t;
        }

        @Override
        public void run() {
            if(t!= null){
                try {
                    t.join();
                    System.out.print(atomicInteger.get());
                    atomicInteger.incrementAndGet();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
