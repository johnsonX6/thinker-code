package com.client.algorithem.binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hqz
 * @create 2024/9/25 18:00
 */
public class Tree2 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        t.setLeft(t2);
        t.setRight(t1);
        t2.setLeft(t3);
        preOrder(t);
    }

    private static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.getData());
        preOrder(treeNode.getLeft());
        preOrder(treeNode.getRight());
    }
}
