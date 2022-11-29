package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class _11_IncreasingTripletSubsequence_LC_334 {

    public boolean increasingTriplet(int[] nums) {

        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;

        for(int num: nums) {
            if(num <= firstNum) {
                firstNum = num;
            } else if(num <= secondNum) {
                secondNum = num;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5};
        boolean output = true;
        Assert.assertEquals(output, increasingTriplet(nums));

        nums = new int[]{5,4,3,2,1};
        output = false;
        Assert.assertEquals(output, increasingTriplet(nums));

        nums = new int[]{2,1,5,0,4,6};
        output = true;
        Assert.assertEquals(output, increasingTriplet(nums));
    }
}
