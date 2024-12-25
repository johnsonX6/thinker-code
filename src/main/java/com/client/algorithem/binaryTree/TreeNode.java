package com.client.algorithem.binaryTree;

/**
 * 二叉树节点
 * @author hqz
 * @create 2023/7/24 20:07
 */

public class TreeNode {
    private TreeNode left;
    private int data;
    private TreeNode right;

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(TreeNode left, int data, TreeNode right) {
        this.left = left;
        this.data = data;
        this.right = right;
    }

    public TreeNode(int data) {
        this.data = data;
    }
}
