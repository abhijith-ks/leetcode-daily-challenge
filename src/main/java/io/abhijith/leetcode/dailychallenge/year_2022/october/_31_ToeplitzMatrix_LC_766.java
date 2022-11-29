package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/toeplitz-matrix/
 */
public class _31_ToeplitzMatrix_LC_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {

        // int m = matrix.length;
        // int n = matrix[0].length;

        // int[] temp = new int[n];
        // for(int i = 0 ; i < n; i++) {
        //     temp[i] = matrix[0][i];
        // }
        // for(int i = 1; i < m; i++) {
        //     shift(temp);
        //     temp[0] = matrix[i][0];
        //     for(int j = 1; j < n; j++) {
        //         if(temp[j] != matrix[i][j]) {
        //             return false;
        //         }
        //     }
        //     System.out.println();
        // }

        // return true;
        return betterSolution(matrix);
    }

    private boolean betterSolution(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }

    private void shift(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
    }

    @Test
    public void test() {
        int[][] matrix = new int[][]{{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        boolean output = true;
        Assert.assertEquals(output, isToeplitzMatrix(matrix));

        matrix = new int[][]{{1,2},{2,2}};
        output = false;
        Assert.assertEquals(output, isToeplitzMatrix(matrix));
    }
}
