package io.abhijith.leetcode.dailychallenge.year_2022.november;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * LC: https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class _29_InsertDeleteGetRandomO1_LC_380 {

    Map<Integer, Integer> map = new HashMap<>();;
    List<Integer> list = new ArrayList<>();

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        int index = list.size();
        list.add(val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastValue = list.get(list.size() - 1);
        list.set(index, lastValue);
        map.replace(lastValue, index);
        map.remove(val);
        list.remove(list.size() - 1);

        return true;

    }

    public int getRandom() {
        int random = new Random().nextInt(list.size());
        return list.get(random);
    }


    @Test
    public void test() {
        Assert.assertTrue(insert(1));
        Assert.assertFalse(remove(2));
        Assert.assertTrue(insert(2));
        Assert.assertNotNull(getRandom());
        Assert.assertTrue(remove(1));
        Assert.assertFalse(insert(2));
        Assert.assertNotNull(getRandom());
    }
}
