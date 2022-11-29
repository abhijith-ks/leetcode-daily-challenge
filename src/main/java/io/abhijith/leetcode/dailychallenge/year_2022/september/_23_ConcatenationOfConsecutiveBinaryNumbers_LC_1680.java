package io.abhijith.leetcode.dailychallenge.year_2022.september;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
 */
public class _23_ConcatenationOfConsecutiveBinaryNumbers_LC_1680 {

    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        // StringBuffer buffer = new StringBuffer();
        // for(int i = 1; i <= n; i++) {
        //     buffer.append(Integer.toBinaryString(i));
        // }
        int result = 0;
        for(int j = 1; j <= n; j++) {
            String binary = Integer.toBinaryString(j);
            for(int i = 0; i < binary.length(); i++) {
                result = (result * 2 + (binary.charAt(i) - '0')) % MOD;
                // result += ((buffer.charAt(i) - '0') * Math.pow(2, x)) % MOD;
                // x++;
            }
        }
        return result;
    }

    @Test
    public void test() {
        int input1 = 1;
        int output1 = 1;
        Assert.assertEquals(concatenatedBinary(input1), output1);

        int input2 = 3;
        int output2 = 27;
        Assert.assertEquals(concatenatedBinary(input2), output2);
    }
}
