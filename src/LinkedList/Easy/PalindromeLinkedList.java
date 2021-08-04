package LinkedList.Easy;

import LinkedList.LinkedListUtils;
import LinkedList.ListNode;

import java.util.Arrays;
import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList o = new PalindromeLinkedList();
        LinkedListUtils llu = new LinkedListUtils();

        System.out.println(
                Arrays.toString(
                        new boolean[]{
                                o.isPalindrome(llu.makeList("1-2-2-1")),
                                o.isPalindrome(llu.makeList("1-2-1-3")),
                                o.isPalindrome(llu.makeList("1-2-3-2-1"))
                        }
                )
        );
        //  [true, false, true]
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return false;

        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        while (!stack.isEmpty()) {
            int ele = stack.pop();
            int ele2 = head.val;

            if (ele != ele2)
                return false;

            head = head.next;
        }

        return true;
    }
}

//  https://leetcode.com/problems/palindrome-linked-list/
