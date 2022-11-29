package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * LC: https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 */
public class _16_MinimumDifficultyofaJobSchedule_LC_1335 {
    int n;
    int d;
    int[] jobDifficulty;
    int[][] mem;
    int[] hardestRemaining;
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.d = d;
        this.jobDifficulty = jobDifficulty;
        this.n = jobDifficulty.length;
        this.hardestRemaining = new int[this.n];

        if(this.n < d) return -1;

        int hardest = 0;
        for(int i = n - 1; i >= 0; i--) {
            hardest = Math.max(hardest, jobDifficulty[i]);
            hardestRemaining[i] = hardest;
        }

        mem = new int[this.n][d];
        for(int i = 0; i < this.n; i++) {
            Arrays.fill(mem[i], -1);
        }

        return dp(0, 1);
    }

    private int dp(int i, int day) {
        if(day == this.d) {
            return hardestRemaining[i];
        }

        if(mem[i][day] == -1) {
            int best = Integer.MAX_VALUE;
            int hardest = 0;
            for(int j = i; j < this.n - (d - day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                best = Math.min(best, hardest + dp(j + 1, day + 1));
            }
            mem[i][day] = best;
        }
        return mem[i][day];
    }

    @Test
    public void test() {
        int[] jobDifficulty = new int[]{6,5,4,3,2,1};
        int d = 2;
        int output = 7;
        Assert.assertEquals(output, minDifficulty(jobDifficulty, d));

        jobDifficulty = new int[]{9,9,9};
        d = 4;
        output = -1;
        Assert.assertEquals(output, minDifficulty(jobDifficulty, d));

        jobDifficulty = new int[]{1,1,1};
        d = 3;
        output = 3;
        Assert.assertEquals(output, minDifficulty(jobDifficulty, d));
    }
}
