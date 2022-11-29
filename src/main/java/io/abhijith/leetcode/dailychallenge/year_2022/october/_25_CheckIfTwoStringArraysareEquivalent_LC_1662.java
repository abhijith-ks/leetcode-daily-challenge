package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */
public class _25_CheckIfTwoStringArraysareEquivalent_LC_1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuffer concat1 = new StringBuffer();
        for(String s: word1) {
            concat1.append(s);
        }

        StringBuffer concat2 = new StringBuffer();
        for(String s: word2) {
            concat2.append(s);
        }

        return concat1.toString().equals(concat2.toString());
    }

    @Test
    public void test() {
        String[] word1 = new String[]{"ab", "c"};
        String[] word2 = new String[]{"a", "bc"};
        boolean output = true;
        Assert.assertEquals(output, arrayStringsAreEqual(word1, word2));

        word1 = new String[]{"a", "cb"};
        word2 = new String[]{"ab", "c"};
        output = false;
        Assert.assertEquals(output, arrayStringsAreEqual(word1, word2));

        word1 = new String[]{"abc", "d", "defg"};
        word2 = new String[]{"abcddefg"};
        output = true;
        Assert.assertEquals(output, arrayStringsAreEqual(word1, word2));
    }
}
