package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */
public class _17_CheckiftheSentenceIsPangram_LC_1832 {

    public boolean checkIfPangram(String sentence) {
        boolean[] arr = new boolean[26];

        for(char c: sentence.toCharArray()) {
            arr[c - 'a'] = true;
        }

        for(int i = 0; i < 26; i++) {
            if(!arr[i]) return false;
        }

        return true;
    }

    @Test
    public void test() {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        boolean output = true;
        Assert.assertEquals(output, checkIfPangram(sentence));

        sentence = "leetcode";
        output = false;
        Assert.assertEquals(output, checkIfPangram(sentence));
    }
}
