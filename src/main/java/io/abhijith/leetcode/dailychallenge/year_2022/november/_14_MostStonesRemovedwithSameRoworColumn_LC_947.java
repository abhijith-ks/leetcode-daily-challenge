package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * LC: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class _14_MostStonesRemovedwithSameRoworColumn_LC_947 {

    final int K = 10001;
    // Returns the representative of vertex x
    int find(int[] rep, int x) {
        if (x == rep[x]) {
            return x;
        }
        return rep[x] = find(rep, rep[x]);
    }
    // Combine the stone x and y, and returns 1 if they were not connected
    int performUnion(int [] rep, int [] size, int x, int y) {
        x = find(rep, x);
        y = find(rep, y);

        if (x == y) {
            return 0;
        }

        if (size[x] > size[y]) {
            rep[y] = x;
            size[x] += size[y];
        } else {
            rep[x] = y;
            size[y] += size[x];
        }

        return 1;
    }

    public int removeStones(int[][] stones) {
        int[] rep = new int[2 * K + 1];
        int[] size = new int[2 * K + 1];
        // Initialize rep to itself and size as 1
        for (int i = 0; i < 2 * K + 1; i++) {
            rep[i] = i;
            size[i] = 1;
        }

        int componentCount = 0;
        HashMap<Integer, Integer> marked = new HashMap<>();
        for (int[] stone : stones) {
            if (!marked.containsKey(stone[0])) {
                componentCount++;
            }

            if (!marked.containsKey(stone[1] + K)) {
                componentCount++;
            }

            marked.put(stone[0], 1);
            marked.put(stone[1] + K, 1);
        }

        for (int i = 0; i < stones.length; i++) {
            int x = stones[i][0];
            int y = stones[i][1] + K;
            // Decrement the componenets if union invloved merging
            componentCount -= performUnion(rep, size, x, y);
        }
        // Return the maximum stone that can be removed
        return stones.length - componentCount;
    }

    @Test
    public void test() {
        int[][] input = new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}};
        int output = 3;
        Assert.assertEquals(output, removeStones(input));

        input = new int[][]{{0,0}};
        output = 0;
        Assert.assertEquals(output, removeStones(input));
    }
}
