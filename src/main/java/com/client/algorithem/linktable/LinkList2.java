package com.client.algorithem.linktable;

/**
 * @author hqz
 * @create 2024/9/25 17:27
 */
public class LinkList2 {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        h.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        print(removeDup(h));
    }

    private static void print(ListNode node){

        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 删除链表中连续重复的节点
     * @param node
     * @return
     */
    private static ListNode removeDup(ListNode node) {
        if(node == null){
            return null;
        }
        ListNode cur = node;
        while(cur != null){
            if(cur.next == null){
                break;
            }
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return node;
    }

}

