package io.abhijith.leetcode.dailychallenge.year_2022.october;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * LC: https://leetcode.com/problems/time-based-key-value-store/
 */
public class _6_TimeBasedKeyValueStore_LC_981 {

    class TimeMap {

        Map<String, TreeMap<Integer, String>> map;
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(!map.containsKey(key)) {
                TreeMap<Integer, String> current = new TreeMap<>();
                map.put(key, current);
            }
            map.get(key).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key)) {
                return "";
            }
            TreeMap<Integer, String> current = map.get(key);
            if(current.containsKey(timestamp)) {
                return current.get(timestamp);
            }

            Integer floorKey = current.floorKey(timestamp);

            if(floorKey != null) {
                return current.get(floorKey);
            }

            // for(int currentTime = timestamp; currentTime > 0; currentTime--) {
            //     if(map.get(key).containsKey(currentTime)) {
            //         return map.get(key).get(currentTime);
            //     }
            // }

            return "";
        }
    }


    @Test
    public void test() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);                                  // store the key "foo" and value "bar" along with timestamp = 1.
        Assert.assertEquals("bar", timeMap.get("foo", 1));          // return "bar"
        Assert.assertEquals("bar", timeMap.get("foo", 3));          // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4);                                 // store the key "foo" and value "bar2" along with timestamp = 4.
        Assert.assertEquals("bar2", timeMap.get("foo", 4));         // return "bar2"
        Assert.assertEquals("bar2", timeMap.get("foo", 5));         // return "bar2"
    }
}
