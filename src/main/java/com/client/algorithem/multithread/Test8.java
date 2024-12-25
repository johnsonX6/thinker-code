package com.client.algorithem.multithread;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author hqz
 * juc包下的生产者-消费者模型
 * @create 2024/10/31 19:54
 */
public class Test8 {

    public static void main(String[] args) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        new Thread(new A(linkedBlockingDeque)).start();
        new Thread(new B(linkedBlockingDeque)).start();
    }

    static class A implements Runnable{
        LinkedBlockingDeque linkedBlockingDeque;

        public A(LinkedBlockingDeque linkedBlockingDeque){
            this.linkedBlockingDeque = linkedBlockingDeque;
        }
        @Override
        public void run() {
            for(int i=0; i< 10;i++){
                try {
                    linkedBlockingDeque.put(i);
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class B implements Runnable{
        LinkedBlockingDeque linkedBlockingDeque;

        public B(LinkedBlockingDeque linkedBlockingDeque){
            this.linkedBlockingDeque = linkedBlockingDeque;
        }

        @Override
        public void run() {
            while (true){
                try {
                    int i = (int) linkedBlockingDeque.take();
                    System.out.println("消费者消费：" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
