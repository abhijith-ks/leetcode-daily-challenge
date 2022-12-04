package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
 */
public class _27_ArithmeticSlicesIISubsequence_LC_446 {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Map<Integer, Integer>[] cnt = new Map[n];
        for (int i = 0; i < n; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long)nums[i] - (long)nums[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int)delta;
                int sum = cnt[j].getOrDefault(diff, 0);
                int origin = cnt[i].getOrDefault(diff, 0);
                cnt[i].put(diff, origin + sum + 1);
                ans += sum;
            }
        }
        return (int)ans;
    }

    @Test
    public void test() {
        int[] input = new int[]{2,4,6,8,10};
        int output = 7;
        Assert.assertEquals(output, numberOfArithmeticSlices(input));

        input = new int[]{7,7,7,7,7};
        output = 16;
        Assert.assertEquals(output, numberOfArithmeticSlices(input));
    }
}
