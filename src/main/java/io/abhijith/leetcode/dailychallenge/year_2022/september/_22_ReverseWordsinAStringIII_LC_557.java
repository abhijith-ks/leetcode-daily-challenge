package io.abhijith.leetcode.dailychallenge.year_2022.september;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class _22_ReverseWordsinAStringIII_LC_557 {

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for(String s1: strs) {
            buffer.append(reverse(s1));
            buffer.append(" ");
        }
        return buffer.substring(0, buffer.length() - 1).toString();
    }

    private String reverse(String s) {
        char[] cArr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            char temp = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = temp;
            i++; j--;
        }

        return new String(cArr);
    }

    @Test
    public void test() {
        String input = "Let's take LeetCode contest";
        String output = "s'teL ekat edoCteeL tsetnoc";
        Assert.assertEquals(reverseWords(input), output);
    }

}

