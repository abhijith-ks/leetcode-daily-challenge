package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/break-a-palindrome/
 */
public class _10_BreakaPalindrome_LC_1328 {

    public String breakPalindrome(String palindrome) {

        // String result = "";
        // if(palindrome.length() < 2) {
        //     return result;
        // }

        // List<String> list = new ArrayList<>();

        // char[] chArr = palindrome.toCharArray();
        // for(int i = 0; i < chArr.length; i++) {
        //     char c = chArr[i];

        //     for(int j = 0; j < 26; j++) {
        //         chArr[i] = (char) ('a' + j);
        //         if(!isPalindrome(chArr)) {
        //             list.add(new String(chArr));
        //         }
        //     }
        //     chArr[i] = c;
        // }
        // if(list.size() == 0) return "";
        // Collections.sort(list);
        // String s = list.get(0);
        // return isPalindrome(s.toCharArray()) ? "" : s;

        return betterSolution(palindrome);
    }

    private String betterSolution(String palindrome) {
        if(palindrome.length() < 2) return "";

        char[] chArr = palindrome.toCharArray();
        for(int i =  0; i < chArr.length / 2; i++) {
            char c = chArr[i];
            if(c != 'a') {
                chArr[i] = 'a';
                if(!isPalindrome(chArr)) {
                    return new String(chArr);
                }
            }
            chArr[i] = c;
        }

        chArr[chArr.length - 1] = 'b';
        return new String(chArr);
    }

    private boolean isPalindrome(char[] s) {
        int i = 0, j = s.length - 1;
        while(i < j) {
            if(s[i] != s[j]) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    @Test
    public void test() {
        String palindrome = "abccba";
        String output = "aaccba";
        Assert.assertEquals(output, betterSolution(palindrome));

        palindrome = "a";
        output = "";
        Assert.assertEquals(output, betterSolution(palindrome));
    }
}
