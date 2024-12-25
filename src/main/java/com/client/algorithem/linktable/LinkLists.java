package com.client.algorithem.linktable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hqz
 * @create 2023/8/23 12:16
 */
public class LinkLists {

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }


    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode revert(ListNode head) {
        // 循环迭代
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }
        return prev;
    }

    /**
     * 反转链表递归实现
     * @param head
     * @return
     */
    public ListNode diGui(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        // 递归反转链表
        ListNode head1 = diGui(head.next);
        // 反转当前节点
        head.next.next = head;
        head.next = null;
        return  head;
    }

    /**
     * 重排链表，从0到N，0，n,1,n-1,2,n-2...
     * @param head
     * @return
     */
    public ListNode _1toN(ListNode head){
        List<ListNode> nodes = new ArrayList<>();
        while(head != null){
            nodes.add(head);
            head = head.next;
        }
        int i=0;
        int j=nodes.size() -1;
        while(i < j){
            nodes.get(i).next = nodes.get(j);
            i++;
            if(i == j){
                break;
            }
            nodes.get(j).next = nodes.get(i);
            j--;
        }
        nodes.get(i).next = null;
        return nodes.get(0);
    }

    /**
     * 链表是否有环
     */
    public static boolean isCircle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next !=null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 链表的中间节点
     */
    public static ListNode midNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next !=null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return slow;
    }

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
        h4.next = h3;
        System.out.println(isCircle(h));


        ListNode h5 = new ListNode(6);
        h4.next = h5;
        ListNode mid = midNode(h);
        System.out.println(mid!= null? mid.val: "");
    }
}
