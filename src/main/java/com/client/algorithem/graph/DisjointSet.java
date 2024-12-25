package com.client.algorithem.graph;

/**
 * @author hqz
 * @create 2024/11/3 18:05
 */
public class DisjointSet {
    /**
     * 利用并查集解决不相交集合的数据结构
     * 图中是否有存在路径 从开始到结束节点
     * @param args
     */
    public static void main(String[] args) {
        Disjoint disjoint = new Disjoint(3);
        int[][] edges= new int[3][2];
        edges[0]=new int[]{0,1};
        edges[1]=new int[]{1,2};
        edges[2] = new int[]{2,0};
        for(int[] edge: edges){
            disjoint.union(edge[0],edge[1]);
        }
        System.out.println( disjoint.isConnected(0, 2));
    }

    static class Disjoint{
        // 表示第i个节点的根节点
        int[] nodes;
        // 有多少个单独的集合
        int count;

        /**
         * 初始化每棵树都是以自己为单个集合
         * @param x
         */
        public Disjoint(int x) {
            this.nodes = new int[x];
            this.count = x;
            for(int i=0 ;i<nodes.length;i++){
                nodes[i] = i;
            }
        }

        /**
         * 将两个集合合并到新的集合，树接到另一颗树
         * @param x
         * @param y
         */
        private void union(int x, int y){
            int xR = findSet(x), yR = findSet(y);
            if(xR == yR) return;
            nodes[xR] = yR;
            count--;
        }

        /**
         * 找到这棵树的根节点
         * 所有树高为2 union最多到3
         * @param x
         * @return
         */
        private int findSet(int x){
            if(nodes[x] != x){
                nodes[x] = findSet(nodes[x]);
            }
            return nodes[x];
        }

        private boolean isConnected(int x, int y){
            return findSet(x) == findSet(y);
        }
    }
}
