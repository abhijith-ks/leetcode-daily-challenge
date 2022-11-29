package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/image-overlap/
 */
public class _27_ImageOverlap_LC_835 {

    private int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {

        int leftShiftCount = 0, rightShiftCount = 0;
        int rRow = 0;
        // count the cells of ones in the overlapping zone.
        for (int mRow = yShift; mRow < M.length; ++mRow) {
            int rCol = 0;
            for (int mCol = xShift; mCol < M.length; ++mCol) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
                    leftShiftCount += 1;
                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol])
                    rightShiftCount += 1;
                rCol += 1;
            }
            rRow += 1;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int maxOverlaps = 0;

        for (int yShift = 0; yShift < A.length; ++yShift)
            for (int xShift = 0; xShift < A.length; ++xShift) {
                // move the matrix A to the up-right and up-left directions.
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
                // move the matrix B to the up-right and up-left directions, which is equivalent to moving A to the down-right and down-left directions
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
            }

        return maxOverlaps;
    }

    @Test
    public void test() {

        int[][] img1 = new int[][]{{1,1,0},{0,1,0},{0,1,0}};
        int[][] img2 = new int[][]{{0,0,0},{0,1,1},{0,0,1}};
        int output = 3;
        Assert.assertEquals(output, largestOverlap(img1, img2));

        img1 = new int[][]{{1}};
        img2 = new int[][]{{1}};
        output = 1;
        Assert.assertEquals(output, largestOverlap(img1, img2));

        img1 = new int[][]{{0}};
        img2 = new int[][]{{0}};
        output = 0;
        Assert.assertEquals(output, largestOverlap(img1, img2));
    }
}
