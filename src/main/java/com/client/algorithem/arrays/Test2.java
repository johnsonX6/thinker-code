package com.client.algorithem.arrays;

/**
 * @author hqz
 * @create 2024/9/25 15:31
 */
public class Test2 {

    public static void main(String[] args) {
        int[] sum = new int[]{1,3,5,1};
        int n = midArr(sum);
        System.out.println(n);
        int[] num1 = new int[]{1,3,5};
        int[] num2 = new int[]{1,4,7};
        int n1 = midArr(num1, num2);
        System.out.println(n1);
    }

    /**
     * 有序数组的中位数
     */
    private static int midArr(int[] sum){
        int n = sum.length;
        if(sum == null || n ==0){
            return 0;
        }

        if(n %2 ==0){
            return (sum[n/2] + sum[n/2 -1])/2;
        }else{
            return sum[n/2];
        }
    }

    private static int midArr(int[] sum1, int[] sum2){
        int count = 0;
        int m = sum1.length;
        int n = sum2.length;
        if(m == 0 && n==0){
            return 0;
        }
        int[] nums = new int[m+n];
        if(m ==0){
            if(n %2 ==0){
                return (sum2[n/2] + sum2[n/2 -1])/2;
            }else{
                return sum2[n/2 ];
            }
        }

        if(n == 0){
            if(m %2 ==0){
                return (sum1[m/2] + sum1[m/2 -1])/2;
            }else{
                return sum1[m/2];
            }
        }
        int i=0,j=0;
        while(count != m+n){
            if(i == m){
                while(j!=n){
                    nums[count++] = sum2[j++];
                }
                break;
            }
            if(j == n){
                while(i!=m) {
                    nums[count++] = sum1[i++];
                }
                break;
            }
            if(sum1[i] < sum2[j]){
                nums[count++] = sum1[i++];
            }else {
                nums[count++] = sum2[j++];
            }
        }
        return midArr(nums);
    }
}
