package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * LC: https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 */
public class _28_FindPlayersWithZeroorOneLosses_LC_2225 {

    public List<List<Integer>> findWinners(int[][] matches) {

        Set<Integer> allPlayers = new HashSet<>();
        Map<Integer, Integer> failedPlayers = new HashMap<>();
        for(int i = 0; i < matches.length; i++) {
            allPlayers.add(matches[i][0]);
            allPlayers.add(matches[i][1]);
            failedPlayers.put(matches[i][1], failedPlayers.getOrDefault(matches[i][1], 0) + 1);
        }

        allPlayers.removeAll(failedPlayers.keySet());
        List<Integer> winners = new ArrayList<>(allPlayers);
        Collections.sort(winners);

        List<Integer> lostOneMatch = new ArrayList<>();

        for(Integer val : failedPlayers.keySet()) {
            if(failedPlayers.get(val) == 1) {
                lostOneMatch.add(val);
            }
        }
        Collections.sort(lostOneMatch);

        List<List<Integer>> result = new ArrayList<>();
        result.add(winners);
        result.add(lostOneMatch);
        return result;
    }

    @Test
    public void test() {
        int[][] input = new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1,2,10));
        result.add(Arrays.asList(4,5,7,8));
        Assert.assertEquals(result.toString(), findWinners(input).toString());

        input = new int[][]{{2,3},{1,3},{5,4},{6,4}};
        result = new ArrayList<>();
        result.add(Arrays.asList(1,2,5,6));
        result.add(Arrays.asList());
        Assert.assertEquals(result.toString(), findWinners(input).toString());
    }
}
