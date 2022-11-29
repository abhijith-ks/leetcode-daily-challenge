package io.abhijith.leetcode.dailychallenge.year_2022.october;

import io.abhijith.leetcode.dailychallenge.utils.ListNode;
import org.junit.Test;

/**
 * LC: https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class _13_DeleteNodeinaLinkedList_LC_237 {

    public void deleteNode(ListNode node) {

        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;

    }

    @Test
    public void test() {
        ListNode head = ListNode.arrayToList(new Integer[]{4,5,1,9});
        int value = 5;
        ListNode temp = head;
        ListNode node = head;
        while(temp != null) {
            if(temp.val == value) {
                node = temp;
                break;
            }
            temp = temp.next;
        }

        deleteNode(node);
        boolean result = false;
        while(head != null) {
            if(head.val == value) {
                result = true;
                break;
            }
            head = head.next;
        }
        assert result == false;
    }
}
