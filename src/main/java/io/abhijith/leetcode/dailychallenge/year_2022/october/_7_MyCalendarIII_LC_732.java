package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * LC: https://leetcode.com/problems/my-calendar-iii/
 */
public class _7_MyCalendarIII_LC_732 {

    class MyCalendarThree {

        TreeMap<Integer, Integer> map;
        public MyCalendarThree() {
            map = new TreeMap<>();
        }

        public int book(int start, int end) {
            if(map.isEmpty()){
                map.put(start, 1);
                map.put(end, -1);
                return 1;
            }

            map.put(start, map.getOrDefault(start,0)+1);
            map.put(end, map.getOrDefault(end,0)-1);

            int result = 0;
            int sum = 0;
            for(Map.Entry<Integer, Integer> e: map.entrySet()){
                sum += e.getValue();
                result = Math.max(result,sum);
            }

            return result;
        }
    }

    @Test
    public void test() {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        Assert.assertEquals(myCalendarThree.book(10, 20), 1); // return 1
        Assert.assertEquals(myCalendarThree.book(50, 60), 1); // return 1
        Assert.assertEquals(myCalendarThree.book(10, 40), 2); // return 2
        Assert.assertEquals(myCalendarThree.book(5, 15), 3); // return 3
        Assert.assertEquals(myCalendarThree.book(5, 10), 3); // return 3
        Assert.assertEquals(myCalendarThree.book(25, 55), 3); // return 3
    }
}
