package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: https://leetcode.com/problems/continuous-subarray-sum/
 */
public class _26_ContinuousSubarraySum_LC_523 {

    public boolean checkSubarraySum(int[] nums, int k) {

        // initialize the hash map with index 0 for sum 0
        Map<Integer, Integer> hashMap = new HashMap<>(Map.of(0, 0));
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if the remainder sum % k occurs for the first time
            if (!hashMap.containsKey(sum % k))
                hashMap.put(sum % k, i + 1);
                // if the subarray size is at least two
            else if (hashMap.get(sum % k) < i)
                return true;
        }
        return false;
    }

    private boolean bruteForce(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            int current = 0;
            for(int j = i; j < nums.length; j++) {
                current += nums[j];
                if(j != i && current % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = new int[]{23,2,4,6,7};
        int k = 6;
        boolean output = true;
        Assert.assertEquals(output, checkSubarraySum(nums, k));

        nums = new int[]{23,2,6,4,7};
        k = 6;
        output = true;
        Assert.assertEquals(output, checkSubarraySum(nums, k));

        nums = new int[]{23,2,6,4,7};
        k = 13;
        output = false;
        Assert.assertEquals(output, checkSubarraySum(nums, k));
    }
}
