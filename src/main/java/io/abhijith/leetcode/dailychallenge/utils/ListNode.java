package io.abhijith.leetcode.dailychallenge.utils;

import lombok.ToString;

// Definition for a List Node.
@ToString
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode arrayToList(Integer[] a) {
        ListNode succ = null;
        ListNode node = null;
        for (int i = a.length-1; i >= 0; i--) {
            node = new ListNode(a[i], succ );
            succ = node;
        }
        return node;
    }

    public static void toString(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
