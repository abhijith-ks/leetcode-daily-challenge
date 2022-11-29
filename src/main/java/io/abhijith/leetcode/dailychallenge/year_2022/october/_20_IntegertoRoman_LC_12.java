package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: https://leetcode.com/problems/integer-to-roman/
 */
public class _20_IntegertoRoman_LC_12 {

    public String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        Map<Integer, String> map = new HashMap<>();

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuffer roman = new StringBuffer("");

        for (int i = 0; i < values.length; i++) {
            int val = num / values[i];
            if (num / values[i] > 0) {
                for (int j = 0; j < val; j++) {
                    roman.append(map.get(values[i]));
                }
                num = num % values[i];
            }
        }

        return roman.toString();
    }

    @Test
    public void test() {
        int num = 3;
        String output = "III";
        Assert.assertEquals(output, intToRoman(num));

        num = 58;
        output = "LVIII";
        Assert.assertEquals(output, intToRoman(num));

        num = 1994;
        output = "MCMXCIV";
        Assert.assertEquals(output, intToRoman(num));
    }
}
