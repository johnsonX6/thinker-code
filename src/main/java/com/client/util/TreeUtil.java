package com.client.util;

import com.client.algorithem.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hqz
 * @create 2023/9/7 21:49
 */
public class TreeUtil {


    /**
     * 112 路径总和
     * 从根节点到叶子节点所有的路径里面，等于target的值是否存在
     * @param root
     * @param target
     * @return
     */
    public boolean sumTarget(TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return root.getData() == target;
        }
        return sumTarget(root.getLeft(), target -  root.getData())
                || sumTarget(root.getRight(), target - root.getData());
    }

    /**
     * 129 求根节点到叶子节点的路径数字，如【1，4，7】：14+17 = 31
     * @param root
     * @param i
     * @return
     */
    public int sumNumbers1(TreeNodeNew root, int i){
        if(root == null) return 0;
        int temp = i*10+ root.val;
        if(root.left == null && root.right == null) return temp;

        return sumNumbers1(root.left, temp) + sumNumbers1(root.right, temp);
    }

    /**
     * 617 二叉树的层平均值
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNodeNew root) {
        List<Integer> counts = new ArrayList<Integer>();
        List<Double> sums = new ArrayList<>();
        dfs(root, 0, counts, sums);
        List<Double> averages = new ArrayList<Double>();
        int size = sums.size();
        for(int i=0; i< size;i++){
            averages.add(sums.get(i)/ counts.get(i));
        }
        return averages;
    }

    public void dfs(TreeNodeNew root, int level, List<Integer> counts,
                    List<Double> sums){
        if(root == null){
            return ;
        }
        if(level < sums.size()){
            counts.set(level, counts.get(level) +1);
            sums.set(level, sums.get(level) + root.val);
        }else{
            sums.add(1.0 * root.val);
            counts.add(1);
        }
        dfs(root.left, level +1, counts, sums);
        dfs(root.right, level +1, counts, sums);
    }

    public int sumNumbers(TreeNodeNew root){
        return sumNumbers1(root, 0);
    }

    public static void main(String[] args) {

    }
}
