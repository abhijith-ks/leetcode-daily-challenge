package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/string-compression-ii/
 */
public class _15_StringCompressionII_LC_1531 {

    public int getLengthOfOptimalCompression(String s, int k) {

        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j] = 999999;
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= k; j++) {
                int cnt = 0, del = 0;
                for(int l = i; l >= 1; l--) { // keep s[i], concat the same, remove the different
                    if(s.charAt(l - 1) == s.charAt(i - 1)) cnt++;
                    else del++;
                    if(j - del >= 0)
                        dp[i][j] = Math.min(dp[i][j],
                                dp[l-1][j-del] + 1 + (cnt >= 100 ? 3 : cnt >= 10 ? 2 : cnt >= 2 ? 1: 0));
                }
                if (j > 0) // delete s[i]
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
            }
        }
        return dp[n][k];
    }

    @Test
    public void test() {
        String input  = "aabbaa";
        int k = 2;
        int output = 2;
        Assert.assertEquals(output, getLengthOfOptimalCompression(input, k));

        input  = "aaaaaaaaaaa";
        k = 0;
        output = 3;
        Assert.assertEquals(output, getLengthOfOptimalCompression(input, k));
    }
}
