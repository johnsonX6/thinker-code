package com.client.algorithem.stack;

import java.util.Stack;

/**
 * @author hqz
 * @create 2024/10/17 22:29
 */
public class MinStack {
    static Stack<Item> stacks = new Stack<Item>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

    }

    static class Item{
        int val;
        int curMin;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getCurMin() {
            return curMin;
        }

        public void setCurMin(int curMin) {
            this.curMin = curMin;
        }
    }

    private static void push(Integer val) {
        Item item = new Item();
        item.setVal(val);
        if (val <= min) {
            min = val;
            item.setCurMin(min);
        }
        stacks.push(item);
    }

    private static void pop(){
        stacks.pop();
        if(stacks.isEmpty()){
            min = Integer.MAX_VALUE;
        }else{
            min = stacks.peek().curMin;
        }
    }

    private static Integer peek(){
        return stacks.peek().val;
    }

    private static int getMin(){
        return min;
    }
}
