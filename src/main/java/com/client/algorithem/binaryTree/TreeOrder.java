package com.client.algorithem.binaryTree;

import java.util.*;

/**
 * @author hqz
 * @create 2023/7/24 20:06
 */
public class TreeOrder {

    /**
     * 按照根左右的顺序来遍历二叉树，也就是先序遍历,
     * 按照栈的特性，先入后出记录二叉树节点
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> orders = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                orders.add(root.getData());
                stack.push(root);
                root = root.getLeft();
            }
            TreeNode tree = stack.pop();
            root = tree.getRight();
        }
        return orders;
    }


    public static List<Integer> preOrderV1(TreeNode treeNode) {
        List<Integer> orders = new ArrayList<>();
        preOrderDiGui(treeNode, orders);
        return orders;
    }

    public static void preOrderDiGui(TreeNode root, List<Integer> orders) {
        if (root == null) {
            return;
        }
        orders.add(root.getData());
        preOrderDiGui(root.getLeft(), orders);
        preOrderDiGui(root.getRight(), orders);
        return;
    }

    public static void main(String[] args) {
        TreeNode first = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        first.setLeft(left);
        first.setRight(right);
//        List<Integer> orders = preOrder(first);
        List<Integer> orders1 = preOrderV1(first);
        System.out.println(orders1);
    }

}
