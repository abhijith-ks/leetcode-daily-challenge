package io.abhijith.leetcode.dailychallenge.year_2022.september;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * LC: https://leetcode.com/problems/find-k-closest-elements/
 */
public class _29_FindKClosestElements_LC_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> {
            return Math.abs(n2 - x) - Math.abs(n1 - x);
        });

        for(int num: arr) {
            if(maxHeap.size() < k) {
                maxHeap.add(num);
            } else {
                if(Math.abs(num - x) < Math.abs(maxHeap.peek() - x)) {
                    maxHeap.remove();
                    maxHeap.add(num);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!maxHeap.isEmpty()) {
            result.add(maxHeap.remove());
        }

        Collections.sort(result);

        return result;
    }

    @Test
    public void test() {
        int[] input1 = {1,2,3,4,5};
        int k = 4, x = 3;
        List<Integer> output1 = Arrays.asList(1,2,3,4);
        Assert.assertEquals(output1, findClosestElements(input1, k, x));

        int[] input2 = {1,2,3,4,5};
        k = 4;
        x = -1;
        List<Integer> output2 = Arrays.asList(1,2,3,4);
        Assert.assertEquals(output2, findClosestElements(input2, k, x));
    }
}
