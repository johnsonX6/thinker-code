package com.client.algorithem.linktable;

/**
 * @author hqz
 * @create 2024/9/28 22:41
 */
public class LinkList3 {

    static class LinkNode{
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkNode head = new LinkNode(1);
        LinkNode h = new LinkNode(2);
        LinkNode h1 = new LinkNode(3);
        LinkNode h2 = new LinkNode(4);
        LinkNode h3 = new LinkNode(5);
        head.next= h;
        h.next = h1;
        h1.next = h2;
        h2.next = h3;

        LinkNode result = reverseBetween(head, 2, 4);

        while (result!= null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /**
     * 将链表中的指定顺序节点反转过来
     * 如1-》2-》3-》4-》5
     * 1-》4-》3-》2-》5
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static LinkNode reverseBetween(LinkNode head, int left, int right) {
        LinkNode dummy = new LinkNode(0);
        dummy.next = head;
        LinkNode p0 = dummy;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }
        LinkNode pre = null;
        LinkNode cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            LinkNode nxt = cur.next;
            cur.next = pre; // 每次循环只修改一个 next，方便大家理解
            pre = cur;
            cur = nxt;
        }

        // 见视频
        p0.next.next = cur;
        p0.next = pre;
        return head;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    private static LinkNode reverseV1(LinkNode head){
        LinkNode prev = null;
        LinkNode cur = head;
        while(cur != null){
            LinkNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
