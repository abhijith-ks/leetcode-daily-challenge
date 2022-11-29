package io.abhijith.leetcode.dailychallenge.year_2022.september;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/push-dominoes/
 */
public class _27_PushDominoes_LC_838 {

    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] indexes = new int[n + 2];
        char[] symbols = new char[n + 2];
        int len = 1;
        indexes[0] = -1;
        symbols[0] = 'L';

        for(int i = 0; i < n; i++) {
            if(dominoes.charAt(i) != '.') {
                indexes[len] = i;
                symbols[len] = dominoes.charAt(i);
                len++;
            }
        }
        indexes[len] = n;
        symbols[len] = 'R';
        len++;

        char[] ans = dominoes.toCharArray();
        for (int index = 0; index < len - 1; ++index) {
            int i = indexes[index], j = indexes[index+1];
            char x = symbols[index], y = symbols[index+1];
            if (x == y) {
                for (int k = i+1; k < j; ++k)
                    ans[k] = x;
            } else if (x > y) { // RL
                for (int k = i+1; k < j; ++k)
                    ans[k] = k-i == j-k ? '.' : k-i < j-k ? 'R' : 'L';
            }
        }
        return String.valueOf(ans);
    }

    @Test
    public void test() {
        String input1 = "RR.L";
        String output1 = "RR.L";
        Assert.assertEquals(output1, pushDominoes(input1));

        String input2 = ".L.R...LR..L..";
        String output2 = "LL.RR.LLRRLL..";
        Assert.assertEquals(output2, pushDominoes(input2));
    }
}
