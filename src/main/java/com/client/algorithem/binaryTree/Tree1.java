package com.client.algorithem.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hqz
 * @create 2024/9/25 17:52
 */
public class Tree1 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        t.setLeft(t1);
        t1.setLeft(t2);
        t2.setLeft(t3);
        System.out.println(depth(t));

        t.setLeft(t1);
        t.setRight(t2);
        t1.setLeft(null);
        t2.setLeft(t3);
        List<List<Integer>> r= level(t);
        for(List<Integer> list : r){
            System.out.println(list);
        };
    }

    /**
     * 求二叉树的深度
     */
    private static int depth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = depth(treeNode.getLeft());
        int right = depth(treeNode.getRight());
        return Math.max(left, right) + 1;
    }

    /**
     * 层序遍历
     */
    private static List<List<Integer>> level(TreeNode treeNode){
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(treeNode, 0, res);
        return res;
    }

    private static void levelOrder(TreeNode root, int level ,List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        List<Integer> i = res.get(level);
        i.add(root.getData());
        levelOrder(root.getLeft(), level + 1, res);
        levelOrder(root.getRight(), level + 1, res);
    }
}
