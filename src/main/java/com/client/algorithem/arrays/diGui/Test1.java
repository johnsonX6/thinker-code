package com.client.algorithem.arrays.diGui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author hqz
 * @create 2024/10/20 11:23
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> A = new CopyOnWriteArrayList<>(Arrays.asList(2,1,0));
        List<Integer> B = new CopyOnWriteArrayList<>();
        List<Integer> C = new CopyOnWriteArrayList<>();
        hanota(A, B, C);
        for (Integer i : C) {
            System.out.print(i);
        }
    }

    public static void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    /**
     * 将n-1个元素从A移到B
     * 将1元素移到C
     * 再将N-1元素从B移到C
     *
     * @param size
     * @param A
     * @param B
     * @param C
     */
    private static void move(int size, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (size == 0) {
            return;
        }
        move(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(size - 1, B, A, C);
    }
}
