package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class _2_NumberofDiceRollsWithTargetSum_LC_1155 {

    Integer[][] mem;
    public int numRollsToTarget(int n, int k, int target) {
        mem = new Integer[n + 1][target + 1];
        return numRolls(0, n, k, target, 0);
    }

    private int numRolls(int diceIndex, int n, int k, int target, int currentSum) {
        if(diceIndex == n) {
            return currentSum == target ? 1 : 0;
        }

        if (mem[diceIndex][currentSum] != null) {
            return mem[diceIndex][currentSum];
        }

        int ways = 0;
        for(int i = 1; i <= Math.min(k, target - currentSum); i++) {
            ways = (ways + numRolls(diceIndex + 1, n, k, target, currentSum + i)) % 1000000007;
        }
        mem[diceIndex][currentSum] = ways;
        return ways;
    }

    @Test
    public void test() {
        int n = 1;
        int k = 6;
        int target = 3;
        int output = 1;
        Assert.assertEquals(output, numRollsToTarget(n, k, target));

        n = 2;
        k = 6;
        target = 7;
        output = 6;
        Assert.assertEquals(output, numRollsToTarget(n, k, target));

        n = 30;
        k = 30;
        target = 500;
        output = 222616187;
        Assert.assertEquals(output, numRollsToTarget(n, k, target));
    }
}
