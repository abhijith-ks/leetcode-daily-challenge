package io.abhijith.leetcode.dailychallenge.year_2022.september;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC: https://leetcode.com/problems/the-skyline-problem/
 */
public class _30_TheSkylineProblem_LC_218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        int[] x = new int[2 * n];
        int[] heights = new int[2 * n];

        for(int i = 0; i < n; i++){
            x[2 * i] = buildings[i][0];
            x[2 * i + 1] = buildings[i][1];
        }


        Arrays.sort(x);
        for(int i = 0; i < n; i++){
            int leftIndex = Arrays.binarySearch(x, buildings[i][0]);
            int rightIndex = Arrays.binarySearch(x, buildings[i][1]);
            for(int j = leftIndex; j < rightIndex; j++){
                heights[j] = Math.max(heights[j], buildings[i][2]);
            }
        }

        int lastBuildingHeight = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < 2*n; i++){
            if(heights[i] != lastBuildingHeight){
                ans.add(Arrays.asList(x[i], heights[i]));
                lastBuildingHeight = heights[i];
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] input1 = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oItem1 = Arrays.asList(2,10);
        List<Integer> oItem2 = Arrays.asList(3,15);
        List<Integer> oItem3 = Arrays.asList(7,12);
        List<Integer> oItem4 = Arrays.asList(12,0);
        List<Integer> oItem5 = Arrays.asList(15,10);
        List<Integer> oItem6 = Arrays.asList(20,8);
        List<Integer> oItem7 = Arrays.asList(24,0);
        result.add(oItem1);
        result.add(oItem2);
        result.add(oItem3);
        result.add(oItem4);
        result.add(oItem5);
        result.add(oItem6);
        result.add(oItem7);
        Assert.assertEquals(result, getSkyline(input1));
    }
}
