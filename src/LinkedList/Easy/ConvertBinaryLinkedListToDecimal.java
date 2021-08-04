package LinkedList.Easy;

import LinkedList.LinkedListUtils;
import LinkedList.ListNode;

public class ConvertBinaryLinkedListToDecimal {
    public static void main(String[] args) {
        // 0-0-0-1-1-0-0-1-0
        ListNode bll = new LinkedListUtils().makeList("0-0-0-1-1-0-0-1-0");

        ConvertBinaryLinkedListToDecimal o = new ConvertBinaryLinkedListToDecimal();
        System.out.println(
                o.convertToDecimal(bll)
        );
        // 50
    }

    public int convertToDecimal(ListNode node) {
        int sum = 0, length = 0;
        ListNode temp = node;

        if (node == null)
            return sum;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        while (node != null) {
            sum += node.val * Math.pow(2, --length);
            node = node.next;
        }

        return sum;
    }

    private void displayList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}

// https://www.geeksforgeeks.org/decimal-equivalent-of-binary-linked-list/
