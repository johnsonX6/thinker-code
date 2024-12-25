package com.client.algorithem.queue;

import java.util.Stack;

/**
 * @author hqz
 * @create 2024/10/17 20:38
 */
public class Test1 {
    static Stack<Integer> stackIn;
    static Stack<Integer> stackOut;

    public Test1(){
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        push(1);
        push(2);
        push(3);
        System.out.println(peek());
        System.out.println(pop());
        System.out.println(peek());
    }

    private static  boolean isEmpty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private static void push(Integer a){
        stackIn.push(a);
    }

    private static Integer pop(){
        inToOut();
        return stackOut.pop();
    }

    private static void inToOut(){
        if(!stackOut.isEmpty()) return;
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }

    private static Integer peek(){
        inToOut();
        return  stackOut.peek();
    }
}
