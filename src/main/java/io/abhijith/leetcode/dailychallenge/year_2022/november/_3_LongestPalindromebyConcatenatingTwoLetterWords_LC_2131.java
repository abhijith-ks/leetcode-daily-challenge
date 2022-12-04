package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/
 */
public class _3_LongestPalindromebyConcatenatingTwoLetterWords_LC_2131 {

    public int longestPalindrome(String[] words) {
        final int ALPHABET_SIZE = 26;
        int[][] count = new int[ALPHABET_SIZE][ALPHABET_SIZE];
        for(String word: words) {
            count[word.charAt(0) - 'a'][word.charAt(1) - 'a'] += 1;
        }

        int result = 0;
        boolean center = false;

        for(int i = 0; i < ALPHABET_SIZE; i++) {
            if(count[i][i] % 2 == 0) {
                result += count[i][i];
            } else {
                center = true;
                result += count[i][i] - 1;
            }
            for(int j = i + 1; j < ALPHABET_SIZE; j++) {
                result += 2 * Math.min(count[i][j], count[j][i]);
            }
        }
        if(center) {
            result += 1;
        }

        return result * 2;
    }

    @Test
    public void test() {
        String[] input = {"lc","cl","gg"};
        int output = 6;
        Assert.assertEquals(output, longestPalindrome(input));

        input = new String[]{"ab","ty","yt","lc","cl","ab"};
        output = 8;
        Assert.assertEquals(output, longestPalindrome(input));

        input = new String[]{"cc","ll","xx"};
        output = 2;
        Assert.assertEquals(output, longestPalindrome(input));
    }
}
