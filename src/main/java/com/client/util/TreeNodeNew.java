package com.client.util;

import com.client.algorithem.binaryTree.TreeNode;

/**
 * @author hqz
 * @create 2023/9/7 22:06
 */
public class TreeNodeNew {
     TreeNodeNew left;
     int val;
    TreeNodeNew right;

    public TreeNodeNew getLeft() {
        return left;
    }

    public void setLeft(TreeNodeNew left) {
        this.left = left;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNodeNew getRight() {
        return right;
    }

    public void setRight(TreeNodeNew right) {
        this.right = right;
    }
}
