package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/decode-ways/
 */
public class _1_DecodeWays_LC_91 {

    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];
        int first = 1;
        int second = s.charAt(0) == '0' ? 0 : 1;
        // dp[0] = 1;
        // dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= s.length(); i++) {
            int result = 0;
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if(oneDigit >= 1 && oneDigit <= 9) {
                // dp[i] += dp[i - 1];
                result += second;
            }
            if(twoDigit >= 10 && twoDigit <= 26) {
                // dp[i] += dp[i - 2];
                result += first;
            }
            first = second;
            second = result;
        }

        return second;
        // return dp[s.length()];
    }

    @Test
    public void test() {
        String input1 = "12";
        int output1 = 2;
        Assert.assertEquals(output1, numDecodings(input1));

        String input2 = "226";
        int output2 = 3;
        Assert.assertEquals(output2, numDecodings(input2));

        String input3 = "06";
        int output3 = 0;
        Assert.assertEquals(output3, numDecodings(input3));
    }
}
