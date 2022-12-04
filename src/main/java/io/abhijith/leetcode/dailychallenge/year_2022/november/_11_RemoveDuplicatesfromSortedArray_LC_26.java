package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class _11_RemoveDuplicatesfromSortedArray_LC_26 {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        while(j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    @Test
    public void test() {
        int[] input = new int[]{1,1,2};
        int output = 2;
        Assert.assertEquals(output, removeDuplicates(input));

        input = new int[]{0,0,1,1,1,2,2,3,3,4};
        output = 5;
        Assert.assertEquals(output, removeDuplicates(input));
    }
}
