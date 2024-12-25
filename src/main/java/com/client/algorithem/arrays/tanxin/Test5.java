package com.client.algorithem.arrays.tanxin;

/**
 * @author hqz
 * @create 2024/10/18 18:33
 */
public class Test5 {
    public static void main(String[] args) {
        int[] nums = new int[]{5,5,5,10,20};
        System.out.println(changeBill(nums));
    }

    /**
     * 柠檬水找零 5元 10元 20元钞票，最小单元是5元，10元，问是否能兑换完
     * @param bills
     * @return
     */
    private static boolean changeBill(int[] bills) {
        int yuan5 = 0;
        int yuan10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                yuan5++;
            } else if (bills[i] == 10) {
                yuan10++;
                yuan5--;
            } else if (bills[i] == 20 && yuan10 >= 1) {
                yuan10--;
                yuan5--;
            } else if (bills[i] == 20 && yuan10 < 1) {
                yuan5 -= 3;
            }
            if (yuan5 < 0 || yuan10 < 0) return false;
        }
        return true;
    }
}
