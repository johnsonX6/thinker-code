package com.client.algorithem.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hqz
 * @create 2024/9/25 17:28
 */
public class Test5 {

    /**
     * 输入数组元素，如果相同则删掉相同的，加上相同的两数之和，如果不同，则保留较大的。
     * @param arr
     * @return
     */
    public static int getArray(List<Integer> arr){
        boolean found = false;
        while(arr.size() > 1) {
            for (int j = 0; j < arr.size() - 1; j++) {
                if (arr.get(j).equals(arr.get(j + 1))) {
                    arr.set(j, arr.get(j) + arr.get(j + 1));
                    arr.remove(j + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                if (arr.get(0) > arr.get(1)) {
                    arr.remove(1);
                } else {
                    arr.remove(0);
                }
            }
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=0; i< n;i++){
            arrayList.add(scanner.nextInt());
        }
        int res = getArray(arrayList);
        System.out.println("最后得到的数字是：" + res);
        scanner.close();
    }
}
