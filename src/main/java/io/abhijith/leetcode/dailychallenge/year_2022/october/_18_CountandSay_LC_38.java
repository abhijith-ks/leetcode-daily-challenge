package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/count-and-say/
 */
public class _18_CountandSay_LC_38 {

    public String countAndSay(int n) {
        String currentString = "1";
        for (int i = 2; i <= n; i++) {
            String nextString = "";
            for (int j = 0, k = 0; j < currentString.length(); j = k) {
                while (k < currentString.length() && currentString.charAt(k) == currentString.charAt(j)) k++;
                nextString += Integer.toString(k - j) + currentString.charAt(j);
            }
            currentString = nextString;
        }
        return currentString;
    }

    @Test
    public void test() {
        int n = 1;
        String output = "1";
        Assert.assertEquals(output, countAndSay(n));

        n = 4;
        output = "1211";
        Assert.assertEquals(output, countAndSay(n));
    }
}
