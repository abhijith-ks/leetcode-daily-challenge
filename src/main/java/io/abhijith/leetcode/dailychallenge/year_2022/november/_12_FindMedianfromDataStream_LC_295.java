package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LC: https://leetcode.com/problems/find-median-from-data-stream/
 */
public class _12_FindMedianfromDataStream_LC_295 {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if(minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

    @Test
    public void test() {
        addNum(1);
        addNum(2);
        double output = 1.5;
        Assert.assertEquals(output, findMedian(), 0);
        addNum(3);
        output = 2.0;
        Assert.assertEquals(output, findMedian(), 0);
    }
}
