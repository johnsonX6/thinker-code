package com.client.algorithem.linktable;

/**
 * @author hqz
 * @create 2024/10/17 09:37
 */
public class LinkList6 {
    static class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkNode h = new LinkNode(3);
        h.next = new LinkNode(5);
        h.next.next = new LinkNode(8);
        h.next.next.next = new LinkNode(5);
        h.next.next.next.next = new LinkNode(10);
        h.next.next.next.next.next = new LinkNode(2);
        LinkNode res = partition(h, 5);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * 链表的小节点元素放到指定值之前 大元素放到指定值之后
     * @param linkNode
     * @param x
     * @return
     */
    private static LinkNode partition(LinkNode linkNode, int x) {
        LinkNode smallH = new LinkNode(0);
        LinkNode smallT = smallH;
        LinkNode greatH = new LinkNode(0);
        LinkNode greatT = greatH;
        while (linkNode != null) {
            if (linkNode.val < x) {
                smallT.next = linkNode;
                smallT = smallT.next;
            } else {
                greatT.next = linkNode;
                greatT = greatT.next;
            }
            linkNode = linkNode.next;
        }
        // 指向大链表的头节点
        smallT.next = greatH.next;
        greatT.next = null;
        return smallH.next;
    }
}
