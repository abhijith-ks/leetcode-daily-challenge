package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LC: https://leetcode.com/problems/earliest-possible-day-of-full-bloom/
 */
public class _29_EarliestPossibleDayofFullBloom_LC_2136 {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {

        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i < growTime.length; i++) {
            indices.add(i);
        }

        // Collections.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
        Collections.sort(indices, (a, b) -> growTime[b] - growTime[a]);

        int result = 0;
        int currentPlatTime = 0;
        for(int i = 0; i < growTime.length; i++) {
            int idx = indices.get(i);
            int time = currentPlatTime + plantTime[idx] + growTime[idx];
            result = Math.max(result, time);
            currentPlatTime += plantTime[idx];
        }

        return result;

    }

    @Test
    public void test() {
        int[] plantTime = new int[]{1,4,3};
        int[] growTime = new int[]{2,3,1};
        int output = 9;
        Assert.assertEquals(output, earliestFullBloom(plantTime, growTime));

        plantTime = new int[]{1,2,3,2};
        growTime = new int[]{2,1,2,1};
        output = 9;
        Assert.assertEquals(output, earliestFullBloom(plantTime, growTime));

        plantTime = new int[]{1};
        growTime = new int[]{1};
        output = 2;
        Assert.assertEquals(output, earliestFullBloom(plantTime, growTime));
    }
}
