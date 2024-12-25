package com.client.algorithem.binaryTree;

/**
 * @author hqz
 * @create 2024/9/30 09:39
 */
public class Test4 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        treeNode.setLeft(t2);
        treeNode.setRight(t3);
        System.out.println(isBST(treeNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    /**
     * 是否是二叉搜索树
     *
     * @param treeNode
     * @return
     */
    private static boolean isBST(TreeNode treeNode, int min, int max) {
        if (treeNode == null) {
            return true;
        }
        if (treeNode.getData() >= max || treeNode.getData() <= min) {
            return false;
        }
        return isBST(treeNode.getLeft(), min, treeNode.getData()) && isBST(treeNode.getRight(), treeNode.getData(), max);
    }
}
