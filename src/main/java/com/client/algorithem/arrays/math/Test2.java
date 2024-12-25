package com.client.algorithem.arrays.math;

/**
 * @author hqz
 * @create 2024/10/20 12:29
 */
public class Test2 {
    public static void main(String[] args) {
        int x = 2;
        System.out.println(peiDui(2));
    }

    /**
     * 符号配对 将整数的奇数位与偶数位互换，使用较少的指令
     * 16进制5是0101 a是1010 与运算是取到奇数位与偶数位，再进行移位
     * @return
     */
    private static int peiDui(int x){
        return ((x & 0x55555555) << 1) | ((x & 0xaaaaaaaa) >> 1);
    }
}
