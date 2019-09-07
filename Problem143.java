//143. Reorder List - M.
//Given a singly linked list L: L0→L1→…→Ln-1→Ln,
//reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//You may not modify the values in the list's nodes, only nodes itself may be changed.

import java.util.Stack;
public class Main {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public void reorderList(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode start = head;
        ListNode end = null;
        int count = 0;
        while (head != null){
            s.push(head);
            count++;
            head = head.next;
        }
        int k = count;
        ListNode w = new ListNode(0);
        while (k > count/2) {
            w = s.pop();
            k--;
        }
        if (count%2 == 1) {
            end = w;
            w = w.next;
            end.next = null;
        }
        while (!s.empty()) {
            ListNode tempL = s.pop();
            ListNode tempR = w.next;
            w.next = end;
            tempL.next = w;
            w = tempR;
            end = tempL;
        }

    }

    public static void main(String[] args) {

    }
}
