package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LC: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class _24_MaximumLengthofaConcatenatedStringwithUniqueCharacters_LC_1239 {

    public int maxLength(List<String> arr) {
        // Use depth first search recursion through arr
        // building from an initial empty string
        return dfs(arr, 0, "");
    }

    private int dfs(List<String> arr, int pos, String res) {
        // Use a set to check res for duplicate characters
        Set<Character> resSet = new HashSet<>();
        for (char c : res.toCharArray())
            resSet.add(c);
        if (res.length() != resSet.size())
            return 0;

        // Recurse through each possible next option
        // and find the best answer
        int best = res.length();
        for (int i = pos; i < arr.size(); i++)
            best = Math.max(best, dfs(arr, i + 1, res + arr.get(i)));
        return best;
    }

    @Test
    public void test() {
        List<String> input = Arrays.asList("un","iq","ue");
        int output = 4;
        Assert.assertEquals(output, maxLength(input));

        input = Arrays.asList("cha","r","act","ers");
        output = 6;
        Assert.assertEquals(output, maxLength(input));

        input = Arrays.asList("abcdefghijklmnopqrstuvwxyz");
        output = 26;
        Assert.assertEquals(output, maxLength(input));
    }
}
