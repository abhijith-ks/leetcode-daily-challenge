package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * LC: https://leetcode.com/problems/top-k-frequent-words/
 */
public class _19_TopKFrequentWords_LC_692 {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            if(map.get(a) == map.get(b)) {
                return b.compareTo(a);
            } else {
                return map.get(a) - map.get(b);
            }
        });


        for(String key: map.keySet()) {
            minHeap.add(key);
            if(minHeap.size() > k)
                minHeap.remove();
        }

        List<String> result = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            result.add(0, minHeap.remove());
        }

        return result;
    }

    @Test
    public void test() {
        String[] words = new String[]{"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> output = Arrays.asList("i","love");
        Assert.assertEquals(output.toString(), topKFrequent(words, k).toString());

        words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        k = 4;
        output = Arrays.asList("the","is","sunny","day");
        Assert.assertEquals(output.toString(), topKFrequent(words, k).toString());
    }
}
