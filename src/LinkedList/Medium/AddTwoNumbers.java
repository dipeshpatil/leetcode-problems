package LinkedList.Medium;

import LinkedList.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers o = new AddTwoNumbers();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        o.displayList(o.addTwoNumbers(l1, l2));
        //  7, 0, 8,
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2, curr = head;

        int carry = 0;

        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0)
            curr.next = new ListNode(carry);

        return head.next;
    }

    private void displayList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}

// https://leetcode.com/problems/add-two-numbers/
