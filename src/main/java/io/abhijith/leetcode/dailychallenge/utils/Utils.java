package io.abhijith.leetcode.dailychallenge.utils;

public class Utils {

    public static void main(String[] args) {
        // Build class name
        String input = "Toeplitz Matrix";
        String lc = "766";
        String day = "31";
        System.out.println(generateClassName(input, lc, day));
    }

    public static String generateClassName(String input, String lc, String day) {
        return "_" + day + "_" + input.replaceAll("\\s|-", "") + "_LC_" + lc;
    }
}
