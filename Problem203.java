//203. Remove Linked List Elements - E.
//Remove all elements from a linked list of integers that have value val.

public class Main {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode d = new ListNode(0);
        d.next = head;
        ListNode prev = d;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                head = head.next;
            } else {
                prev = prev.next;
                head = head.next;
            }

        }
        return d.next;

    }

    public static void main(String[] args) {

    }
}
