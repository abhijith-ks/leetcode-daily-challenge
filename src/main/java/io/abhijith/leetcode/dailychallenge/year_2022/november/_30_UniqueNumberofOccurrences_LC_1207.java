package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC: https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class _30_UniqueNumberofOccurrences_LC_1207 {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for(int key: map.keySet()) {
            if(set.contains(map.get(key))) {
                return false;
            }
            set.add(map.get(key));
        }

        return true;
    }

    @Test
    public void test() {
        int[] input = new int[]{1,2,2,1,1,3};
        boolean output = true;
        Assert.assertEquals(output, uniqueOccurrences(input));

        input = new int[]{1,2};
        output = false;
        Assert.assertEquals(output, uniqueOccurrences(input));

        input = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        output = true;
        Assert.assertEquals(output, uniqueOccurrences(input));
    }
}
