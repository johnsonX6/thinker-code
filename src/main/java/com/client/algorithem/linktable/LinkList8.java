package com.client.algorithem.linktable;

import java.util.*;

/**
 * @author hqz
 * @create 2024/10/17 18:17
 */
public class LinkList8 {

    static class LinkNode{
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LinkNode h = new LinkNode(1);
        LinkNode h1 = new LinkNode(2);
        LinkNode h2 = new LinkNode(3);
        LinkNode h3 = new LinkNode(4);
//        LinkNode h4 = new LinkNode(5);
        h.next = h1;
        h1.next = h2;
        h2.next = h3;
//        h3.next = h4;

//        LinkNode linkNode = midNode(h);
//        System.out.println(linkNode.val);

//        h3.next = h2;
//        System.out.println(hasCircle(h));
//        LinkNode res = reverseNode(h);

//        LinkNode res = reverse1(h);
//        while (res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }

//        String s="aaabbbbcd";
//        System.out.println(compress(s));
//
//        String s1 = "{{[]}}";
//        System.out.println(isValid(s1));
//
//        String s2 = "[[}}";
//        System.out.println(isValid(s2));
//        LinkNode res = removeK(h, 1);
//        while (res != null) {
//            System.out.print(res.val + " ");
//            res = res.next;
//        }
        System.out.println(compareVersion("1.01", "1.001"));

//        int[][] nums1 = new int[3][4];
//        nums1[0]= new int[]{1,1,1,1};
//        nums1[1] =new int[]{1,1,0,1};
//        nums1[2] = new int[]{0,0,0,0};
//        System.out.println(irlands(nums1));

        LinkNode j = new LinkNode(1);
        LinkNode j1 = new LinkNode(4);
        LinkNode j2 = new LinkNode(3);
        LinkNode j3 = new LinkNode(2);
//        LinkNode h4 = new LinkNode(5);
        j.next = j1;
        j1.next = j2;
        j2.next = j3;
        LinkNode res = sortList(j);
                while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }


    /**
     * 翻转left到right之间的元素
     * @param head
     * @param left
     * @param right
     * @return
     */
    private static LinkNode reverse(LinkNode head, int left, int right){
        LinkNode dummy = new LinkNode(0);
        dummy.next = head;
        LinkNode pre = null ;
        LinkNode p0 = dummy;
        for(int i=0; i< left;i++){
            p0 = p0.next;
        }
        LinkNode cur = p0.next;
        for(int i=0; i< right - left+1 ;i++){
            LinkNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        dummy.next.next = head;
        dummy.next = pre;
        return head;
    }
    
    private static LinkNode midNode(LinkNode head){
        LinkNode fast = head;
        LinkNode slow = head;

        while(fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        };
        return slow;
    }

    private static boolean hasCircle(LinkNode head){
        LinkNode fast = head;
        LinkNode slow = head;
        while(fast.next!= null && fast.next.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    private static LinkNode iteractNode(LinkNode h, LinkNode h1) {
        if (h == null || h1 == null) {
            return null;
        }
        LinkNode p0 = h;
        LinkNode p1 = h1;
        while (p0 != p1) {
            p0 = p0.next != null ? p0.next : h1;
            p1 = p1.next != null ? p1.next : h;
        }
        return p0;
    }

    public static LinkNode reverseNode(LinkNode head) {
        if (head == null) {
            return null;
        }
        LinkNode pre = null;
        LinkNode cur = head;
        while (cur != null) {
            LinkNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private static LinkNode reverse1(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 保存尾指针
        LinkNode tail = reverse1(head.next);
        head.next.next = head;
        // 置空，递归乙保存上一节点
        head.next = null;
        return tail;
    }

    private static String compress(String a) {
        int l = 0;
        int r = a.length();
        StringBuilder res = new StringBuilder();
        while (l < r) {
            int count = 1;
            while (l < r - 1 && a.charAt(l) == a.charAt(l + 1)) {
                count++;
                l++;
            }
            res.append(a.charAt(l)).append(count);
            l++;
        }
        return res.length() < r ? res.toString() : a;
    }

    /**
     * 括号匹配
     * 利用栈先进后出的思想 遇到左括号放入栈中，遇到右括号，出栈判断是否匹配，栈为空也不符合，依次遍历
     * 最后栈空也是符合要求
     */
    private static boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
                stack.push(ch[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char tmp = stack.pop();
                if ((tmp != '(' && ch[i] == ')') || tmp != '{' && ch[i] == '}' ||
                        (tmp != '[' && ch[i] == ']')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    /**
     * 删除倒数第k个节点
     * @param head
     * @param k
     * @return
     */
    private static LinkNode removeK(LinkNode head, int k) {
        LinkNode slow = head;
        LinkNode fast = head;
        LinkNode pre = null;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(slow == null){
            return head;
        }
        pre.next = slow.next;
        slow.next = null;
        return head;
    }

    private static int compareVersion(String a, String b){
        String[] a1 = a.split("\\.");
        String[] a2 = b.split("\\.");
        for(int n=0; n< Math.max(a1.length, a2.length);n++){
            int i = n<a1.length? Integer.parseInt(a1[n]): 0;
            int j = n< a2.length? Integer.parseInt(a2[n]):0;
            if(i< j) return -1;
            else if(i> j) return 1;
        }
        return 0;
    }

    private static int irlands(int[][] grids){
        int nr = grids.length;
        int nc = grids[0].length;
        int count = 0;
        for(int i=0;i< nr;i++){
            for(int j=0;j< nc;j++){
                if(grids[i][j] == 1){
                    count++;
                    dfs(grids,i,j);
                }
            }
        }
        return count;
    }

    private static void dfs(int[][] grids, int i, int j) {
        int nr = grids.length;
        int nc = grids[0].length;
        if (i < 0 || j < 0 || i >= nr || j >= nc || grids[i][j] == 0) {
            return;
        }
        grids[i][j] = 0;
        dfs(grids, i - 1, j);
        dfs(grids, i + 1, j);
        dfs(grids, i, j - 1);
        dfs(grids, i, j + 1);
    }

    /**
     * 排序链表 将链表重新排序然后返回新的链表
     * @param head
     * @return
     */
    private static LinkNode sortList(LinkNode head) {
        if (head == null) {
            return null;
        }
        LinkNode cur = new LinkNode(0);
        LinkNode pre = cur;
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        int[] nums = new int[res.size()];
        for(int i=0;i< res.size();i++){
            nums[i] = res.get(i);
        }
        Arrays.sort(nums);
        for(int i=0;i< nums.length;i++){
            LinkNode nxt = new LinkNode(nums[i]);
            cur.next = nxt;
            cur = cur.next;
        }
        cur.next = null;
        return pre.next;
    }
}
