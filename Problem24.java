//24. Swap Nodes in Pairs - M.
//Given a linked list, swap every two adjacent nodes and return its head.
//
//You may not modify the values in the list's nodes, only nodes itself may be changed.
public class Main {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    //Recursion:
//    public ListNode swapPairs(ListNode head) {
//        if ((head == null)||(head.next == null))
//            return head;
//        ListNode n = head.next;
//        head.next = swapPairs(head.next.next);
//        n.next = head;
//        return n;
//    }
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode d = new ListNode(0);
        d.next = head;
        head = d;
        while (head != null && head.next!= null && head.next.next != null) {
            ListNode f = head.next;
            ListNode s = head.next.next;
            ListNode t = head.next.next.next;
            head.next = s;
            head.next.next = f;
            head.next.next.next = t;
            head = head.next.next;
        }
        return d.next;

    }
    public static void main(String[] args) {

    }
}
