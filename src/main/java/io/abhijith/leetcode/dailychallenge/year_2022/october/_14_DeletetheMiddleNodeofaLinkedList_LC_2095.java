package io.abhijith.leetcode.dailychallenge.year_2022.october;

import io.abhijith.leetcode.dailychallenge.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
 */
public class _14_DeletetheMiddleNodeofaLinkedList_LC_2095 {

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = slow;

        while(fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    @Test
    public void test() {
        ListNode head = ListNode.arrayToList(new Integer[]{1,3,4,7,1,2,6});
        ListNode expected = ListNode.arrayToList(new Integer[]{1,3,4,1,2,6});
        deleteMiddle(head);
        Assert.assertEquals(head.toString(), expected.toString());
    }
}
