package io.abhijith.leetcode.dailychallenge.utils;

public class Utils {

    public static void main(String[] args) {
        // Build class name
        String input = "Unique Number of Occurrences";
        String lc = "1207";
        String day = "30";
        System.out.println(generateClassName(input, lc, day));
    }

    public static String generateClassName(String input, String lc, String day) {
        return "_" + day + "_" + input.replaceAll("\\s|-", "") + "_LC_" + lc;
    }
}
