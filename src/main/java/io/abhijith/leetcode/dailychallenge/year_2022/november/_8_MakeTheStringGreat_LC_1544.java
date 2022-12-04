package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * LC: https://leetcode.com/problems/make-the-string-great/
 */
public class _8_MakeTheStringGreat_LC_1544 {

    public String makeGood(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c: s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                if(Math.abs(stack.peek() - c) == 32) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuffer buffer = new StringBuffer();
        while(!stack.isEmpty()) {
            buffer.insert(0, stack.pop());
        }

        return buffer.toString();
    }

    @Test
    public void test() {
        String s = "leEeetcode";
        String output = "leetcode";
        Assert.assertEquals(output, makeGood(s));

        s = "abBAcC";
        output = "";
        Assert.assertEquals(output, makeGood(s));

        s = "s";
        output = "s";
        Assert.assertEquals(output, makeGood(s));
    }
}
