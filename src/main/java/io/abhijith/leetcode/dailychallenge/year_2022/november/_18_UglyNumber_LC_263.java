package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/ugly-number/
 */
public class _18_UglyNumber_LC_263 {

    public boolean isUgly(int n) {

        if(n == 1) return true;
        if(n <= 0) return false;

        while(n % 2 == 0) {
            n = n / 2;
        }

        while(n % 3 == 0) {
            n = n / 3;
        }

        while(n % 5 == 0) {
            n = n / 5;
        }

        return n == 1;

    }

    @Test
    public void test() {
        int input = 6;
        boolean output = true;
        Assert.assertEquals(output, isUgly(input));

        input = 1;
        output = true;
        Assert.assertEquals(output, isUgly(input));

        input = 14;
        output = false;
        Assert.assertEquals(output, isUgly(input));
    }
}
