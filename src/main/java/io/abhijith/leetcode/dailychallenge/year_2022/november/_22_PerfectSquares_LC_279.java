package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: https://leetcode.com/problems/perfect-squares/
 */
public class _22_PerfectSquares_LC_279 {

    public int numSquares(int n) {

        List<Integer> perfectSquares = new ArrayList<>();

        if(n == 1) return 1;

        int x = 1;
        while(x * x <= n) {
            perfectSquares.add(x * x);
            x += 1;
        }

        int[] arr = new int[n + 1];
        Arrays.fill(arr, n + 1);
        arr[0] = 0;

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < perfectSquares.size(); j++) {
                if(perfectSquares.get(j) <= i)
                    arr[i] = Math.min(arr[i], arr[i - perfectSquares.get(j)] + 1);
            }
        }

        return arr[n];

    }

    @Test
    public void test() {
        int input = 12;
        int output = 3;
        Assert.assertEquals(output, numSquares(input));

        input = 13;
        output = 2;
        Assert.assertEquals(output, numSquares(input));
    }
}
