package com.client.algorithem.linktable;

import com.client.algorithem.binaryTree.TreeNode;

/**
 * @author hqz
 * @create 2024/10/15 12:07
 */
public class LinkList4 {
    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        h.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        
       int n = kth(h, 2);
        System.out.println(n);
    }

    private static void print(ListNode h) {
        while(h != null){
            System.out.print(h.val + "");
            h = h.next;
        }
    }

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }

    /**
     * 链表中倒数第k个节点
     * @param listNode
     * @param k
     * @return
     */
    private static int kth(ListNode listNode, int k){
        if(listNode == null){
            return -1;
        }
        ListNode fast = listNode;
        ListNode slow = listNode;
        for(int i=0;i< k;i++){
               fast = fast.next;
        };
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
