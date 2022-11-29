package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * LC: https://leetcode.com/problems/3sum-closest/
 */
public class _8_3SumClosest_LC_16 {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int minValue = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length && minValue != 0; i++) {
            int low = i + 1;
            int high = nums.length - 1;

            while(low < high) {
                int current = nums[i] + nums[low] + nums[high];

                if(Math.abs(target - current) < Math.abs(minValue)) {
                    minValue = target - current;
                }

                if(current < target) {
                    low += 1;
                } else {
                    high -= 1;
                }
            }
        }

        return target - minValue;
    }

    @Test
    public void test() {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        int output = 2;
        Assert.assertEquals(output, threeSumClosest(nums, target));

        nums = new int[]{0,0,0};
        target = 1;
        output = 0;
        Assert.assertEquals(output, threeSumClosest(nums, target));
    }
}
