package LinkedList.Easy;

import LinkedList.LinkedListUtils;
import LinkedList.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1Test = LinkedListUtils.makeList("1-2-4");
        ListNode l2Test = LinkedListUtils.makeList("1-3-4");

        MergeTwoSortedLists o = new MergeTwoSortedLists();
        LinkedListUtils.displayList(o.mergeTwoSortedLists(l1Test, l2Test));

        // 1-1-2-3-4-4
    }

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0, null);
        ListNode head = temp;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                head.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                head.next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        return temp.next;
    }
}

// https://leetcode.com/problems/merge-two-sorted-lists/
