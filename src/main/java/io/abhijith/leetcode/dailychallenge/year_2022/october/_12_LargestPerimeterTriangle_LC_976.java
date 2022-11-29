package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * LC: https://leetcode.com/problems/largest-perimeter-triangle/
 */
public class _12_LargestPerimeterTriangle_LC_976 {

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 3; i >= 0; i--) {
            if(nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2,1,2};
        int output = 5;
        Assert.assertEquals(output, largestPerimeter(nums));

        nums = new int[]{1,2,1};
        output = 0;
        Assert.assertEquals(output, largestPerimeter(nums));
    }
}
