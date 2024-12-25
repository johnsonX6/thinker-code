package com.client.algorithem.arrays.od;

/**
 * @author hqz
 * @create 2024/10/18 17:15
 */
public class Test2 {

    public static void main(String[] args) {
        String s = "abcabcabc";
        char A = 'a', B = 'b', C = 'c';
        System.out.println(findLongestEvenLength(s, A, B, C));
    }

    private static int longestSubStringV1(String s, char A, char B, char C) {
        if (s.isEmpty()) {
            return 0;
        }
        int maxLen = 0;
        int countA = 0, countB = 0, countC = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == A) {
                countA++;
            } else if (c == B) {
                countB++;
            } else if (c == C) {
                countC++;
            }
            while (((countA % 2 != 0) || (countB % 2 != 0) || (countC % 2 != 0)) && l <= i) {
                char tmp = s.charAt(l);
                if (tmp == A) {
                    countA--;
                } else if (tmp == B) {
                    countB--;
                } else if (tmp == c) {
                    countC--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }

    /**
     * 要计算包含指定字符（例如 'a', 'b', 'c'）
     * 数量为偶数的最长子串的长度，可以使用动态规划的方法。我们可以创建三个数组，分别记录以每个字符作为子串结尾时，
     * 该字符之前出现的次数（是奇数还是偶数）。然后遍历字符串，更新这些数组，并记录最长的偶数出现次数子串长度。
     * @param str
     * @param char1
     * @param char2
     * @param char3
     * @return
     */
    public static int findLongestEvenLength(String str, char char1, char char2, char char3) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int[] prev1 = new int[str.length()];
        int[] prev2 = new int[str.length()];
        int[] prev3 = new int[str.length()];

        int maxLength = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        for (int i = 0; i < str.length(); i++) {
            prev1[i] = (str.charAt(i) == char1) ? count1 : 0;
            prev2[i] = (str.charAt(i) == char2) ? count2 : 0;
            prev3[i] = (str.charAt(i) == char3) ? count3 : 0;

            count1 += (str.charAt(i) == char1) ? 1 : 0;
            count2 += (str.charAt(i) == char2) ? 1 : 0;
            count3 += (str.charAt(i) == char3) ? 1 : 0;

            boolean isEven = (count1 % 2 == 0) && (count2 % 2 == 0) && (count3 % 2 == 0);
            if (isEven) {
                int length = i + 1;
                for (int j = 0; j < i; j++) {
                    if ((prev1[j] ^ prev1[i]) == 0 && (prev2[j] ^ prev2[i]) == 0 && (prev3[j] ^ prev3[i]) == 0) {
                        length = Math.max(length, i - j + 1);
                    }
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }



}
