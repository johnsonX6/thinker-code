package com.client.algorithem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 微信红包算法
 * @author hqz
 * @create 2023/7/24 19:33
 */
public class RedPackAlg {

    /**
     * 如果1份，全部分完，多份红包，计算本次剩下的总金额，且随机一个金额在最小，最大区间内，
     *
     *
     * @param amount 总金额
     * @param min 最低分到金额
     * @param max 最高分到金额
     * @param count 要分的份数
     * @return
     */
    private List<BigDecimal> randomAmount(BigDecimal amount, BigDecimal min, BigDecimal max, int count) {
        List<BigDecimal> allAmount = new ArrayList<>();
        BigDecimal leaveAmount = amount;
        BigDecimal totalAmounts = new BigDecimal(0);
        for (int i = count; i > 1; count--) {
            BigDecimal curAmount;
            if (count == 1) {
                    System.out.println("====="+ count + "=====" +leaveAmount);
                    allAmount.add(leaveAmount);

                return allAmount;
            } else {
                curAmount = BigDecimal.valueOf(
                        ThreadLocalRandom.current().nextDouble(min.doubleValue(), max.doubleValue())).setScale(2, RoundingMode.HALF_UP);
                leaveAmount = leaveAmount.subtract(curAmount);
//                totalAmounts.add(curAmount);
                if (leaveAmount.compareTo(BigDecimal.ZERO) >= 0) {
                    allAmount.add(curAmount);
                }
            }
        }
        Collections.shuffle(allAmount);
        return allAmount;
    }


    public static void main(String[] args) {
        BigDecimal allAmount = new BigDecimal(100);
        BigDecimal min = new BigDecimal(1);
        BigDecimal max = new BigDecimal(5);
        List<BigDecimal> counts = new RedPackAlg().randomAmount(allAmount, min, max, 25);
        System.out.println(counts);
        System.out.println(counts.size());
        System.out.println(counts.stream().mapToDouble(BigDecimal::doubleValue).sum());

    }
}
