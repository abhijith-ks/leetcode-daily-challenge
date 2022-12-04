package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * LC: https://leetcode.com/problems/where-will-the-ball-fall/
 */
public class _1_WhereWilltheBallFall_LC_1706 {

    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        int colSize = grid[0].length;
        int rowSize = grid.length;

        for(int i = 0; i < colSize; i++) {

            int rIndex = 0;
            int cIndex = i;

            for(rIndex = 0; rIndex < rowSize; rIndex++) {
                if(cIndex + 1 < colSize && grid[rIndex][cIndex] > 0
                        && grid[rIndex][cIndex + 1] > 0) {
                    cIndex++;
                } else if (cIndex - 1 >= 0 && grid[rIndex][cIndex] < 0
                        && grid[rIndex][cIndex - 1] < 0) {
                    cIndex--;
                } else {
                    result[i] = -1;
                }
            }
            result[i] = result[i] == -1 ? -1 : cIndex;
        }
        return result;
    }

    @Test
    public void test() {

        int[][] grid = new int[][]{{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
        int[] output = new int[]{1,-1,-1,-1,-1};
        Assert.assertTrue(Arrays.equals(output, findBall(grid)));

        grid = new int[][]{{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
        output = new int[]{0,1,2,3,4,-1};
        Assert.assertTrue(Arrays.equals(output, findBall(grid)));
    }

}
