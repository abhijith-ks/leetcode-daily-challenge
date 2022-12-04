package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/rectangle-area/
 */
public class _17_RectangleArea_LC_223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int firstLength = Math.abs(ax1 - ax2);
        int firstWidth = Math.abs(ay1 - ay2);
        int secondLength = Math.abs(bx1 - bx2);
        int secondWidth = Math.abs(by1 - by2);

        int firstArea = firstLength * firstWidth;
        int secondArea = secondLength * secondWidth;

        // calculate x overlap
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int xOverlap = right - left;

        // calculate y overlap
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);
        int yOverlap = top - bottom;

        int areaOfOverlap = 0;
        // if the rectangles overlap each other, then calculate
        // the area of the overlap
        if (xOverlap > 0 && yOverlap > 0) {
            areaOfOverlap = xOverlap * yOverlap;
        }

        return firstArea + secondArea - areaOfOverlap;
    }

    @Test
    public void test() {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        int output = 45;
        Assert.assertEquals(output, computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));

        ax1 = -2; ay1 = -2; ax2 = 2; ay2 = 2; bx1 = -2; by1 = -2; bx2 = 2; by2 = 2;
        output = 16;
        Assert.assertEquals(output, computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
    }
}
