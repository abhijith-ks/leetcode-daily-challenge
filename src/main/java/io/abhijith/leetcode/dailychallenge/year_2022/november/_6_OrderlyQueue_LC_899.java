package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * LC: https://leetcode.com/problems/orderly-queue/
 */
public class _6_OrderlyQueue_LC_899 {

    public String orderlyQueue(String s, int k) {

        if(k == 1) {
            String ans = s;
            for(int i = 0; i < s.length(); i++) {
                String temp = s.substring(i, s.length()) + s.substring(0, i);
                ans = ans.compareTo(temp) < 0 ? ans : temp;
            }
            return ans;
        } else {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            return new String(charArr);
        }
    }

    @Test
    public void test() {

        String s = "cba";
        int k = 1;
        String output = "acb";
        Assert.assertEquals(output, orderlyQueue(s, k));

        s = "baaca";
        k = 3;
        output = "aaabc";
        Assert.assertEquals(output, orderlyQueue(s, k));
    }
}
