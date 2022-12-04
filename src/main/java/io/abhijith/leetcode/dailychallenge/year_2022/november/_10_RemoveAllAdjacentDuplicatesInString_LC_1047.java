package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * LC: https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class _10_RemoveAllAdjacentDuplicatesInString_LC_1047 {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == current) {
                stack.pop();
                continue;
            } else {
                stack.push(current);
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
        String input = "abbaca";
        String output = "ca";
        Assert.assertEquals(output, removeDuplicates(input));

        input = "azxxzy";
        output = "ay";
        Assert.assertEquals(output, removeDuplicates(input));
    }
}
