package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * LC: https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class _13_ReverseWordsinaString_LC_151 {

    public String reverseWords(String s) {


        StringBuffer buffer = new StringBuffer();
        Stack<String> stack = new Stack<>();
        String[] strs = s.split("\\s+");
        for(String str: strs) {
            stack.push(str);
        }

        while(!stack.isEmpty()) {
            buffer.append(stack.pop());
            if(!stack.isEmpty()) {
                buffer.append(" ");
            }
        }

        return buffer.toString().trim();
    }

    @Test
    public void test() {
        String input = "the sky is blue";
        String output = "blue is sky the";
        Assert.assertEquals(output, reverseWords(input));

        input = "  hello world  ";
        output = "world hello";
        Assert.assertEquals(output, reverseWords(input));

        input = "a good   example";
        output = "example good a";
        Assert.assertEquals(output, reverseWords(input));
    }
}
