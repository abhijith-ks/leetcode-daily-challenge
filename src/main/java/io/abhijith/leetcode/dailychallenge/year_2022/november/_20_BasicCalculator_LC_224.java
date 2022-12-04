package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * LC: https://leetcode.com/problems/basic-calculator/
 */
public class _20_BasicCalculator_LC_224 {

    public int evaluateExpr(Stack<Object> stack) {

        // If stack is empty or the expression starts with
        // a symbol, then append 0 to the stack.
        // i.e. [1, '-', 2, '-'] becomes [1, '-', 2, '-', 0]
        if (stack.empty() || !(stack.peek() instanceof Integer)) {
            stack.push(0);
        }

        int res = (int) stack.pop();

        // Evaluate the expression till we get corresponding ')'
        while (!stack.empty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }

    public int calculate(String s) {

        int operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                // Forming the operand - in reverse order.
                operand = (int) Math.pow(10, n) * (int) (ch - '0') + operand;
                n += 1;

            } else if (ch != ' ') {
                if (n != 0) {

                    // Save the operand on the stack
                    // As we encounter some non-digit.
                    stack.push(operand);
                    n = 0;
                    operand = 0;

                }
                if (ch == '(') {

                    int res = evaluateExpr(stack);
                    stack.pop();

                    // Append the evaluated result to the stack.
                    // This result could be of a sub-expression within the parenthesis.
                    stack.push(res);

                } else {
                    // For other non-digits just push onto the stack.
                    stack.push(ch);
                }
            }
        }

        //Push the last operand to stack, if any.
        if (n != 0) {
            stack.push(operand);
        }

        // Evaluate any left overs in the stack.
        return evaluateExpr(stack);
    }

    @Test
    public void test() {
        String s = "1 + 1";
        int output = 2;
        Assert.assertEquals(output, calculate(s));

        s = " 2-1 + 2 ";
        output = 3;
        Assert.assertEquals(output, calculate(s));

        s = "(1+(4+5+2)-3)+(6+8)";
        output = 23;
        Assert.assertEquals(output, calculate(s));
    }
}
