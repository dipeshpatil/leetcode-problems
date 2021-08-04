package LinkedList;

public class LinkedListUtils {
    public LinkedListUtils() {
    }

    public ListNode makeList(String input) {
        ListNode node, temp = new ListNode(0, null);
        node = temp;

        for (String x : input.split("-")) {
            temp.next = new ListNode(Integer.parseInt(x), null);
            temp = temp.next;
        }

        return node.next;
    }
}
