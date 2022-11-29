package io.abhijith.leetcode.dailychallenge.year_2022.september;

import io.abhijith.leetcode.dailychallenge.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class _28_RemoveNthNodeFromEndofList_LC_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode firstPointer = head;
        ListNode secondPointer = head;
        ListNode prevPointer = null;

        int counter = 0;
        while(firstPointer != null) {
            if(counter >= n) {
                prevPointer = secondPointer;
                secondPointer = secondPointer.next;
            }
            firstPointer = firstPointer.next;
            counter++;
        }
        if(prevPointer != null) {
            prevPointer.next = secondPointer.next;
        } else {
            head = head.next;
        }

        return head;

    }

    @Test
    public void test() {
        Integer[] input1 = {1,2,3,4,5};
        ListNode head1 = ListNode.arrayToList(input1);
        ListNode output1 = ListNode.arrayToList(new Integer[]{1,2,3,5});
        Assert.assertEquals(output1.toString(), removeNthFromEnd(head1, 2).toString());

        Integer[] input2 = {1};
        ListNode head2 = ListNode.arrayToList(input2);
        ListNode output2 = null;
        Assert.assertEquals(output2, removeNthFromEnd(head2, 1));
    }
}
