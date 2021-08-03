package LinkedList;

public class LinkedListUtils {
    private final String input;

    public LinkedListUtils(String input) {
        this.input = input;
    }

    public ListNode makeList() {
        ListNode node, temp = new ListNode(0, null);
        node = temp;

        for (String x : this.input.split("-")) {
            temp.next = new ListNode(Integer.parseInt(x), null);
            temp = temp.next;
        }

        return node.next;
    }
}
