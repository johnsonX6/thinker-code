package com.client.algorithem.multithread;


/**
 * @author hqz
 * @create 2024/10/16 14:29
 */
public class Test2 {

    public static void main(String[] args) {
        Thread a = new Thread(new Work());
        Thread b = new Thread(new Work1(a));
        a.start();
        b.start();
    }

    static class Work implements Runnable{

        public Work() {
        }

        @Override
        public void run() {
            System.out.println("Work执行：");
        }
    }

    /**
     * join等待另外一个线程执行完再执行本线程
     */
    static class Work1 implements Runnable{
        private Thread work;

        public Work1(Thread work) {
            this.work = work;
        }

        @Override
        public void run() {
            if(!(this.work == null)){
                try {
                    work.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Work1执行：");
            }
        }
    }
}
