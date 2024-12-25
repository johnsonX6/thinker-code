package com.client.algorithem.linktable;

/**
 * @author hqz
 * @create 2024/10/15 16:24
 */
public class LinkList5 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        ListNode result = partition(head, 5);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 将链表中小于k的节点放到指定值节点前面，大于k的节点都在指定值节点后面
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode smallerTail = smallerHead;
        ListNode greaterHead = new ListNode(0);
        ListNode greaterTail = greaterHead;

        while (head != null) {
            if (head.val < x) {
                smallerTail.next = head;
                smallerTail = smallerTail.next;
            } else {
                greaterTail.next = head;
                greaterTail = greaterTail.next;
            }
            head = head.next;
        }

        smallerTail.next = greaterHead.next;
        greaterTail.next = null;

        return smallerHead.next;
    }
}
