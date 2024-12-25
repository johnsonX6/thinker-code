package com.client.algorithem;

import com.client.algorithem.linktable.LinkList6;
import com.client.algorithem.linktable.LinkList8;

import java.util.*;

/**
 * @author hqz
 * @create 2024/11/1 15:23
 */
public class Test1101 {


    public static void main(String[] args) {
//        printMatrix(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(7);
        t1.setLeft(t2);
        t1.setRight(t3);
//        System.out.println(levelPrintOrder(t1));

//        System.out.println(isBST(t1));
//        t1.setVal(8);
//        t1.setLeft(t3);
//        t1.setRight(t2);
//        System.out.println(isBST(t1));
        String s = "1235641";
//        System.out.println(maxIncrLen(s));

//        List<Integer> l = new ArrayList<>();
//        preOrder(t1, l);
//        System.out.println(l);
        int[] nums = new int[]{2,4,4,10,8,6,1};
//        System.out.println(midSearch(nums, 4));
//        mergeSort(nums);
        bubble(nums);
        for(int i: nums){
            System.out.print(i+" ");
        }
//        int[] g =new int[]{3,6,1,8};
//        int[] ss = new int[]{7,4,0,2};
//        System.out.println(fenFa(g, ss));
//        System.out.println(countN(nums));
//        String fullS="aeagtenh";
//        String subS = "eagt";
//        System.out.println(kmp(fullS, subS));

//        String ss="pwwkew";
//        System.out.println(longestSubStr(ss));
//        int[] numsTwo = new int[]{-1,3,1,9,6};
//        System.out.println(twoSum(numsTwo));
        int[] numsThree = new int[]{2,-2,0,2,-4};
        System.out.println(threeSum(numsThree));
        
//        LinkNode h = new LinkNode(1);
//        h.next = new LinkNode(2);
//        h.next.next = new LinkNode(3);
//        h.next.next.next = new LinkNode(4);
//        h.next.next.next.next = new LinkNode(5);
//        h.next.next.next.next.next = new LinkNode(6);
//        LinkNode res = reSortLinkNode(h);
//        while(res != null){
//            System.out.print(res.val + "    ");
//            res= res.next;
//        }

//        LinkNode h = new LinkNode(1);
//        h.next = new LinkNode(4);
//        h.next.next = new LinkNode(5);
//        h.next.next.next = new LinkNode(3);
//        h.next.next.next.next = new LinkNode(2);
//        h.next.next.next.next.next = new LinkNode(6);
//        LinkNode res = partitionNode(h, 5);
//        while(res != null){
//            System.out.print( res.val + "   ");
//            res = res.next;
//        }
        int[][] lands = new int[4][5];
        // 静态初始化
        int[][] lands1= {
                {1,2},
                {3,4}
        };
        // 动态初始化 先声明大小，再初始化内容
        // 或者循环赋值
        // 使用Arrays。fill
//        lands[0]=new int[]{1,1,1,1,0};
//        lands[1]= new int[]{1,1,0,1,0};
//        lands[2] = new int[]{1,1,0,0,0};
//        lands[3] = new int[]{0,0,0,0,0};
//        System.out.println(islands(lands));

//        LinkNode a1 = new LinkNode(1);
//        LinkNode a2 = new LinkNode(2);
//        LinkNode b1 = new LinkNode(3);
//        LinkNode b2 = new LinkNode(4);
//        a1.next=a2;
//        b1.next=b2;
//        LinkNode res = mergeList(a1, b1);
//                while(res != null){
//            System.out.print( res.val + "   ");
//            res = res.next;
//        }
//        LinkNode p1 = new LinkNode(1);
//        headList(p1, 4);
//        while(p1!= null){
//            System.out.print(p1.val+" ");
//            p1 = p1.next;
//        }
//        LinkedList1 linkedList1 = new LinkedList1();
//        linkedList1.add(new LinkNode(1));
//        linkedList1.add(new LinkNode(2));
//        linkedList1.add(new LinkNode(3));
//        linkedList1.printNode();
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.add(new LinkNode(1));
        linkedList2.add(new LinkNode(2));
        linkedList2.add(new LinkNode(3));
        linkedList2.printNode();
    }

    private static void printMatrix(int n) {
        int[][] m = new int[n][n];
        int rowS = 0;
        int rowE = n - 1;
        int colS = 0;
        int colE = n - 1;
        int idx = 1;
        while (idx <= n * n) {
            for (int i = colS; i <= colE; i++) {
                m[rowS][i] = idx++;
            }
            rowS++;
            // 0-2 1-2 2-2
            for (int i = rowS; i <= rowE; i++) {
                m[i][colE] = idx++;
            }
            colE--;
            if (rowS < rowE) {
//                2-2 2-1 2-0
                for (int i = colE; i >= colS; i--) {
                    m[rowE][i] = idx++;
                }
                rowE--;
            }
            if (colS < colE) {
                // 2-0 1-0 0-0
                for (int i = rowE; i >= rowS; i--) {
                    m[i][colS] = idx++;
                }
                colS++;
            }
        }
        for (int[] a : m) {
            for (int a1 : a) {
                System.out.print(a1 + " ");
            }
            System.out.println();
        }
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    /**
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    private static List<List<Integer>> levelPrintOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return null;
        }
        if( root.left == null || root.right == null){
            return res;
        }
        levelOrder(root,0, res);
        return res;
    }

    private static void levelOrder(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> l = res.get(level);
        l.add(root.getVal());
        levelOrder(root.getLeft(), level + 1, res);
        levelOrder(root.getRight(), level + 1, res);
    }

    /**
     * 是否二叉搜索树
     * @param t
     * @return
     */
    private static boolean isBST(TreeNode t){
        if(t == null){
            return false;
        }
        return isBSTDiGui(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTDiGui(TreeNode t, int minValue, int maxValue) {
        if (t == null) {
            return true;
        }
        if (t.val > maxValue || t.val < minValue) {
            return false;
        }
        return isBSTDiGui(t.getLeft(), Integer.MIN_VALUE, t.val)
                && isBSTDiGui(t.getRight(), t.val,Integer.MAX_VALUE);
    }

    private static int maxIncrLen(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(i - 1)) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }

        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.getVal());
        preOrder(root.getLeft(), res);
        preOrder(root.getRight(), res);
    }

    private static int midSearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r--;
            } else {
                l++;
            }
        }
        return -1;
    }

    /**
     * 时间复杂度O（nlogn）
     * @param nums
     */
    private static void mergeSort(int[] nums){
        if(nums.length <= 1){
            return;
        }
        int mid = nums.length/2;
        int[] left = new int[mid];
        int[] right = new int[nums.length -mid];
        System.arraycopy(nums,0, left,0,mid);
        System.arraycopy(nums,mid, right,0, nums.length -mid);
        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);
    }

    private static void merge(int[] nums, int[] left, int[] right) {
        int i = 0, j = 0, idx = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[idx++] = left[i++];
            } else {
                nums[idx++] = right[j++];
            }
        }
        while (i < left.length) {
            nums[idx++] = left[i++];
        }
        while (j < right.length) {
            nums[idx++] = right[j++];
        }
    }

    /**
     * 时间复杂度为O（n*n）
     * @param nums
     */
    private static void bubble(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[j] < nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    private static int fenFa(int[] g, int[] s) {
        int count = 0, i = 0, j = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while (i < g.length && j< s.length) {
            if (g[i] > s[j]) {
                j++;
            } else {
                count++;
                j++;
                i++;
            }
        }
        return count;
    }

    /**
     * 数组元素重复次数最多的次数 数组的度
     * @param nums
     * @return
     */
    private static int countN(int[] nums){
        Map<Integer, Integer> res = new HashMap<>();
        for(int i=0;i< nums.length;i++){
            if(res.containsKey(nums[i])){
                res.put(nums[i], res.getOrDefault(nums[i], 0)+1);
            }else{
                res.put(nums[i], 1);
            }
        }
        return res.entrySet().stream().map(Map.Entry::getValue)
                .max(Comparator.naturalOrder()).orElse(0);
    }

    private static int degree(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i])) {
                res.put(nums[i], res.getOrDefault(nums[i], 0) + 1);
            } else {
                res.put(nums[i], 1);
            }
        }
        Map.Entry e = res.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();
//        res.entrySet().stream().max((o1,o2) ->  o1.getValue() - o2.getValue()).get();
        return (int) e.getKey();
    }

    /**
     * 字符串匹配 子串在字符串中是否包含
     * @param s
     * @param subS
     * @return
     */
    private static boolean kmp(String s, String subS) {
        if (s.length() < subS.length()) {
            return false;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String tmp = s.substring(i, j);
                if (tmp.equals(subS)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 最长不重复子串，滑动窗口+哈希表 指针 r 遍历字符 s ，哈希表统计字符 s[r] 最后一次出现的索引
     * 每轮更新左边界l，更新哈希表当前字符最后依次索引，保证区间【l+1， r】无重复且最大，
     * 更新结果res = max（res， r-l）；
     * @param s
     * @return
     */
    private static int longestSubStr(String s) {
        int maxLen = 0, l = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(l, map.get(s.charAt(r)));
            }
            map.put(s.charAt(r), r);
            maxLen = Math.max(maxLen, r - l);
        }
        return maxLen;
    }

    private static int twoSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > 0) return -1;
            if (i < nums.length-1 && nums[i + 1] == nums[i]) continue;
            for(int j=i+1;j< nums.length;j++) {
                int sum = nums[i] + nums[j];
                if (sum == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 求三数之和有多少组，输出组的数量
     * @param nums
     * @return
     */
    private static int threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int count = 0, l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[0] > 0) return -1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 初始化左指针，指向当前值的下一个值
            l = i + 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    count++;
                    l++;
                    r--;
                    while (l <= r && nums[l] == nums[l + 1]) l++;
                    while (l <= r && nums[r] == nums[r--]) r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }

    static class LinkNode{
        int val;
        LinkNode next;

        public LinkNode(int val) {
            this.val = val;
        }
    }


    private static LinkNode reSortLinkNode(LinkNode head) {
        if (head == null) {
            return null;
        }
        LinkNode cur = head;
        List<LinkNode> nodes = new ArrayList<>();
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        int i = 0, j = nodes.size() - 1;
        while (i <= j) {
            nodes.get(i).next = nodes.get(j);
            i++;
            if (i == j) {
                break;
            }
            nodes.get(j).next = nodes.get(i);
            j--;
        }
        nodes.get(i).next= null;
        return nodes.get(0);
    }

    /**
     * 将小于target的值放入链表前，大于target值的放入链表后，不改变相对顺序
     * @param head
     * @param target
     * @return
     */
    private static LinkNode partitionNode(LinkNode head, int target) {
        LinkNode smallHead = new LinkNode(0);
        LinkNode smallTail = smallHead;
        LinkNode greatH = new LinkNode(0);
        LinkNode greatT = greatH;
        while (head != null) {
            if (head.val < target) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                greatT.next = head;
                greatT = greatT.next;
            }
            head = head.next;
        }
        smallTail.next = greatH.next;
        greatT.next = null;
        return smallHead.next;
    }

    /**
     * 求岛屿数量 被四周海洋包围的既是岛屿
     * @param grids
     * @return
     */
    private static int islands(int[][] grids) {
        int nr = grids.length;
        int nc = grids[0].length;
        int count = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grids[i][j] == 1) {
                    count++;
                    dfs(grids, i, j);
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

    private static LinkNode mergeList(LinkNode a, LinkNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        if (a.val > b.val) {
            b.next = mergeList(a, b.next);
            return b;
        } else {
            a.next = mergeList(a.next, b);
            return a;
        }
    }

    /**
     * 按指定数量构建链表
     * @param a
     * @param n
     * @return
     */
    private static LinkNode headList(LinkNode a, int n){
        int i=2;
        LinkNode cur = a;
        while(i< n+1){
            LinkNode a1 = new LinkNode(i++);
            a.next= a1;
            a = a1;
        }
        return cur;
    }


    static class LinkedList1 {
        LinkNode h;

        public LinkedList1() {
            h = null;
        }
        /**
         * 头插法建立链表 逆序构建 如：4-》3-》2-》1
         *
         * @param newNode
         */
        void add(LinkNode newNode) {
            if (h == null) {
                h = newNode;
            } else {
                newNode.next = h;
                h = newNode;
            }
        }

        void printNode() {
            while (h != null) {
                System.out.print(h.val + " ");
                h = h.next;
            }
        }
    }

    /**
     * 尾插法构建链表 顺序构建 1-》2-》3-》4
     */
    static class LinkedList2{
        LinkNode h;
        LinkNode t;
        public LinkedList2(){
            h = null;
            t=null;
        }

        void add(LinkNode newNode) {
            if (h == null) {
                h = newNode;
                t = newNode;
            } else {
                t.next = newNode;
                t = newNode;
            }
        }

        void printNode() {
            while (h != null) {
                System.out.print(h.val + " ");
                h = h.next;
            }
        }
    }

}
