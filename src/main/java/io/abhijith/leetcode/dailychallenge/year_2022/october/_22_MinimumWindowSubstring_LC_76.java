package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * LC: https://leetcode.com/problems/minimum-window-substring/
 */
public class _22_MinimumWindowSubstring_LC_76 {

    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;
        int required = map.size();
        int formed = 0;
        int windowSize = -1;
        int firstIndex = 0;
        int lastIndex = 0;

        Map<Character, Integer> map2 = new HashMap<>();

        while(r < s.length()) {
            char c = s.charAt(r);
            // if(map.containsKey(c)) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            if(map.containsKey(c) && map2.get(c).equals(map.get(c))) {
                formed++;
            }

            while(l <= r && formed == required) {
                c = s.charAt(l);
                if(windowSize == -1 || windowSize > r - l + 1) {
                    windowSize = r - l + 1;
                    firstIndex = l;
                    lastIndex = r;
                }

                map2.put(c, map2.getOrDefault(c, 0) - 1);
                if(map.containsKey(c) && map2.get(c).intValue() < map.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            // }

            r++;
        }

        return (windowSize == -1) ? "" : s.substring(firstIndex, lastIndex + 1);
    }

    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String output = "BANC";
        Assert.assertEquals(output, minWindow(s, t));

        s = "a";
        t = "a";
        output = "a";
        Assert.assertEquals(output, minWindow(s, t));

        s = "a";
        t = "aa";
        output = "";
        Assert.assertEquals(output, minWindow(s, t));
    }
}
