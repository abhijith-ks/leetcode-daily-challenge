package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LC: https://leetcode.com/problems/reverse-vowels-of-a-string/
 */
public class _4_ReverseVowelsofaString_LC_345 {

    public String reverseVowels(String s) {

        int i = 0;
        int j = s.length() - 1;

        Set<Character> vowels = new HashSet<>();
        vowels.addAll(Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        char[] arr = s.toCharArray();

        while(i < j) {
            while(i < j && !vowels.contains(arr[i])) {
                i++;
            }
            while(i < j && !vowels.contains(arr[j])) {
                j--;
            }
            if(vowels.contains(arr[i]) && vowels.contains(arr[j])) {
                char c = arr[i];
                arr[i] = arr[j];
                arr[j] = c;
            }
            i++; j--;
        }

        return new String(arr);
    }

    @Test
    public void test() {
        String input = "hello";
        String output = "holle";
        Assert.assertEquals(output, reverseVowels(input));

        input = "leetcode";
        output = "leotcede";
        Assert.assertEquals(output, reverseVowels(input));
    }
}
