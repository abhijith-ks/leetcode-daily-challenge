package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
 */
public class _3_MinimumTimetoMakeRopeColorful_LC_1578 {

    public int minCost(String colors, int[] neededTime) {
        if (neededTime.length < 2) return 0;
        int result = 0;

        for(int i = 1; i < neededTime.length; i++) {
            if(colors.charAt(i - 1) == colors.charAt(i)) {
                if(neededTime[i] < neededTime[i - 1])  {
                    result += neededTime[i];
                    neededTime[i] = neededTime[i - 1];
                } else {
                    result += neededTime[i - 1];
                }
            }
        }

        return result;
    }

    @Test
    public void test() {
        String colors = "abaac";
        int[] neededTime = new int[]{1,2,3,4,5};
        int result = 3;
        Assert.assertEquals(result, minCost(colors, neededTime));

        colors = "abc";
        neededTime = new int[]{1,2,3};
        result = 0;
        Assert.assertEquals(result, minCost(colors, neededTime));

        colors = "aabaa";
        neededTime = new int[]{1,2,3,4,1};
        result = 2;
        Assert.assertEquals(result, minCost(colors, neededTime));
    }
}
