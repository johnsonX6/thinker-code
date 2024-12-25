package com.client.algorithem.linktable;

/**
 * @author hqz
 * @create 2024/10/17 10:40
 */
public class LinkList7 {

    static class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkNode h = new LinkNode(1);
        LinkNode h1 = new LinkNode(9);
        LinkNode h2 = new LinkNode(1);
        LinkNode h3 = new LinkNode(2);
        LinkNode h4 = new LinkNode(4);
        h.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next =h4;

        LinkNode a = new LinkNode(3);
        LinkNode a1  = h3;
        LinkNode a2 = new LinkNode(4);
        a.next = a1;
        a1.next = a2;
        LinkNode r = getInteractive(h, a);
        System.out.println(r != null? r.val:"");
    }

    /**
     * 相交链表
     * @param A
     * @param B
     * @return
     */
    private static LinkNode getInteractive(LinkNode A, LinkNode B) {
        if (A == null || B == null) {
            return null;
        }
        LinkNode p1 = A;
        LinkNode p2 = B;
        while (p1 != p2) {
            p1 = p1 == null ? B : p1.next;
            p2 = p2 == null ? A : p2.next;
        }
        return p1;
    }
}
