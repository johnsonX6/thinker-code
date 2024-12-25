package com.client.algorithem.binaryTree;

/**
 * @author hqz
 * @create 2024/10/17 17:08
 */
public class Tree5 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(1);
        t.setLeft(t1);
        t1.setLeft(t2);
        t2.setLeft(t3);
        System.out.println(treeSum(t, 4));
    }

    /**
     * 二叉树的路径上所有节点总和等于目标值
     */
    private static boolean treeSum(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return root.getData()  == target;
        }
        return treeSum(root.getLeft(), target - root.getData()) || treeSum(root.getRight(), target - root.getData());
    }
}
