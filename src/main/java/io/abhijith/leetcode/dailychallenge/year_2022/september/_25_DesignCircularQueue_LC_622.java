package io.abhijith.leetcode.dailychallenge.year_2022.september;

import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/design-circular-queue/
 */
public class _25_DesignCircularQueue_LC_622 {

    class MyCircularQueue {

        int front;
        int end;
        int capacity;
        int[] queue;

        public MyCircularQueue(int k) {
            this.queue = new int[k];
            this.front = -1;
            this.end = -1;
            this.capacity = k;
        }

        public boolean enQueue(int value) {

            if (!isFull()) {
                end = (end + 1) % capacity;
                queue[end] = value;
                if (front == -1) {
                    front = end;
                }
                return true;
            }
            return false;
        }

        public boolean deQueue() {

            if (!isEmpty()) {
                if (end == front) {    // if has only sigle element
                    end = -1;
                    front = -1;
                    return true;
                }
                front = (front + 1) % capacity;
                return true;
            }
            return false;
        }

        public int Front() {
            if (!isEmpty())
                return queue[front];
            return -1;
        }

        public int Rear() {
            if (!isEmpty())
                return queue[end];
            return -1;
        }

        public boolean isEmpty() {
            return front == -1;
        }

        public boolean isFull() {
            return (end + 1) % capacity == front;
        }
    }

    @Test
    public void test() {
//        Input : ["MyCircularQueue", "enQueue", "enQueue", "enQueue", "enQueue", "Rear", "isFull", "deQueue", "enQueue", "Rear"]
//        [[3], [1], [2], [3], [4], [], [], [], [4], []]
//        Output : [null, true, true, true, false, 3, true, true, true, 4]
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        Assert.assertTrue(myCircularQueue.enQueue(1));
        Assert.assertTrue(myCircularQueue.enQueue(2));
        Assert.assertTrue(myCircularQueue.enQueue(3));
        Assert.assertFalse(myCircularQueue.enQueue(4));
        Assert.assertEquals(3, myCircularQueue.Rear());
        Assert.assertTrue(myCircularQueue.isFull());
        Assert.assertTrue(myCircularQueue.deQueue());
        Assert.assertTrue(myCircularQueue.enQueue(4));
        Assert.assertEquals(4, myCircularQueue.Rear());
    }
}
