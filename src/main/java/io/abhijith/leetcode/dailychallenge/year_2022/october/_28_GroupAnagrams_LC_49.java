package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * LC: https://leetcode.com/problems/group-anagrams/
 */
public class _28_GroupAnagrams_LC_49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }

    @Test
    public void test() {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<String> list1 = new ArrayList<>(Arrays.asList("bat"));
        List<String> list2 = new ArrayList<>(Arrays.asList("nat","tan"));
        List<String> list3 = new ArrayList<>(Arrays.asList("ate","eat","tea"));
        List<List<String>> output = new ArrayList<>();
        output.addAll(Arrays.asList(list1, list2, list3));
//        Sorting in the list for testing
        List<List<String>> result = groupAnagrams(strs);
        output.forEach(Collections::sort);
        result.forEach(Collections::sort);
        Assert.assertTrue(output.containsAll(result) && result.containsAll(output));
    }
}
