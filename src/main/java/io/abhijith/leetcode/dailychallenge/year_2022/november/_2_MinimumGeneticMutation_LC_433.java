package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * LC: https://leetcode.com/problems/minimum-genetic-mutation/
 */
public class _2_MinimumGeneticMutation_LC_433 {

    public int minMutation(String start, String end, String[] bank) {

        Queue<String> queue = new LinkedList<>();
        int steps = 0;
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>(Arrays.asList(bank));

        queue.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                String current = queue.remove();
                if(current.equals(end)) {
                    return steps;
                }

                for(char c: new char[]{'A', 'T', 'G', 'C'}) {
                    for(int i = 0; i < current.length(); i++) {
                        String neighbor = current.substring(0, i) + c + current.substring(i + 1);
                        if(!visited.contains(neighbor) && set.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.add(neighbor);
                        }
                    }
                }
            }
            steps += 1;
        }

        return -1;
    }

    @Test
    public void test() {
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int output = 1;
        Assert.assertEquals(output, minMutation(startGene, endGene, bank));

        startGene = "AACCGGTT";
        endGene = "AAACGGTA";
        bank = new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"};
        output = 2;
        Assert.assertEquals(output, minMutation(startGene, endGene, bank));
    }
}
