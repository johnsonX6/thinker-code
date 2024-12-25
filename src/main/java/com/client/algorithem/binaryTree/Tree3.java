package com.client.algorithem.binaryTree;

/**
 * @author hqz
 * @create 2024/9/25 18:17
 */
public class Tree3 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        t.setLeft(t1);
        t1.setLeft(t2);
        t2.setLeft(t3);
        TreeNode treeNode = reverse(t);
        preOrder(treeNode);
    }

    /**
     * 二叉树的翻转 左子树换右子树
     *
     * @param treeNode
     * @return
     */
    private static TreeNode reverse(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode tmp = treeNode.getLeft();
        treeNode.setLeft(treeNode.getRight());
        treeNode.setRight(tmp);
        reverse(treeNode.getLeft());
        reverse(treeNode.getRight());
        return treeNode;
    }

    private static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
        System.out.println(treeNode.getData());
    }
}
