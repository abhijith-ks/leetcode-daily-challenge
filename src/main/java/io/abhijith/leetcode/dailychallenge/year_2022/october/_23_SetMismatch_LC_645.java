package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * LC: https://leetcode.com/problems/set-mismatch/
 */
public class _23_SetMismatch_LC_645 {

    public int[] findErrorNums(int[] nums) {
        boolean[] arr = new boolean[nums.length + 1];

        int[] result = new int[2];
        for(int i = 1; i < nums.length + 1; i++) {
            if(arr[nums[i - 1]]) {
                result[0] = nums[i - 1];
            }
            arr[nums[i - 1]] = true;
        }

        for(int i = 1; i < nums.length + 1; i++) {
            if(!arr[i]) {
                result[1] = i;
                break;
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[] input = new int[]{1,2,2,4};
        int[] output = new int[]{2,3};
        Assert.assertTrue(Arrays.equals(output, findErrorNums(input)));

        input = new int[]{1,1};
        output = new int[]{1,2};
        Assert.assertTrue(Arrays.equals(output, findErrorNums(input)));
    }
}
