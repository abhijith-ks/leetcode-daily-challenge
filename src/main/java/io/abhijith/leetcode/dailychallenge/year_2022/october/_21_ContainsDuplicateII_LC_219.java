package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: https://leetcode.com/problems/contains-duplicate-ii/
 */
public class _21_ContainsDuplicateII_LC_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        boolean output = true;
        Assert.assertEquals(output, containsNearbyDuplicate(nums, k));

        nums = new int[]{1,0,1,1};
        k = 1;
        output = true;
        Assert.assertEquals(output, containsNearbyDuplicate(nums, k));

        nums = new int[]{1,2,3,1,2,3};
        k = 2;
        output = false;
        Assert.assertEquals(output, containsNearbyDuplicate(nums, k));
    }
}
