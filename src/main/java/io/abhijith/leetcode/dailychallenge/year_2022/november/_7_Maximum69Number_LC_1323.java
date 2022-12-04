package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/maximum-69-number/
 */
public class _7_Maximum69Number_LC_1323 {

    public int maximum69Number (int num) {
        String numS = num + "";
        char[] cArr = numS.toCharArray();

        for(int i = 0; i < cArr.length; i++) {
            if(cArr[i] == '6') {
                cArr[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(cArr));
    }

    @Test
    public void test() {
        int num = 9669;
        int output = 9969;
        Assert.assertEquals(output, maximum69Number(num));

        num = 9996;
        output = 9999;
        Assert.assertEquals(output, maximum69Number(num));

        num = 9999;
        output = 9999;
        Assert.assertEquals(output, maximum69Number(num));
    }
}
