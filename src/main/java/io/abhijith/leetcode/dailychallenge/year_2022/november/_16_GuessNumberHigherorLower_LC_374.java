package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/guess-number-higher-or-lower/
 */
public class _16_GuessNumberHigherorLower_LC_374 {

    int actual;
    private int guess(int num) {
        return Integer.compare(actual, num);
    }

    public int guessNumber(int n) {

        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int val = guess(mid);
            if(val == 0) {
                return mid;
            } else if(val == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }

    @Test
    public void test() {
        actual = 6;
        int input = 10;
        int output = 6;
        Assert.assertEquals(output, guessNumber(input));

        actual = 1;
        input = 1;
        output = 1;
        Assert.assertEquals(output, guessNumber(input));

        actual = 1;
        input = 2;
        output = 1;
        Assert.assertEquals(output, guessNumber(input));
    }
}
