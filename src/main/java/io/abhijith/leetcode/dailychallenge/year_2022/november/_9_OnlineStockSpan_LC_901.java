package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * LC: https://leetcode.com/problems/online-stock-span/
 */
public class _9_OnlineStockSpan_LC_901 {

    class Price {
        int price;
        int count;
        Price(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }

    Stack<Price> stack = stack = new Stack<>();;

    public int next(int price) {
        int current = 1;
        while(!stack.isEmpty() && stack.peek().price <= price) {
            current += stack.pop().count;
        }
        stack.push(new Price(price, current));
        return current;
    }

    @Test
    public void test() {
        int input = 100;
        int output = 1;
        Assert.assertEquals(output, next(input));

        input = 80;
        output = 1;
        Assert.assertEquals(output, next(input));

        input = 60;
        output = 1;
        Assert.assertEquals(output, next(input));

        input = 70;
        output = 2;
        Assert.assertEquals(output, next(input));

        input = 60;
        output = 1;
        Assert.assertEquals(output, next(input));

        input = 75;
        output = 4;
        Assert.assertEquals(output, next(input));

        input = 85;
        output = 6;
        Assert.assertEquals(output, next(input));
    }
}
