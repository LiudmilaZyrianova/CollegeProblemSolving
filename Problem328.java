/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode start = new ListNode(-1, head);
        ListNode prt = start;
        
        prt = prt.next;
        if (head == null || head.next == null) { return head;}
        ListNode startEven = new ListNode(-2, head.next);
        while (prt.next != null && prt.next.next != null && prt.next.next.next != null) {
            ListNode odd = prt.next.next;
            ListNode even = prt.next.next.next;
            prt.next.next = even;
            prt.next = odd;
            prt = prt.next;
        }
        
        if (prt.next != null && prt.next.next != null) {
            ListNode odd = prt.next.next;
            ListNode even = null;
            prt.next.next = even;
            prt.next = odd;
            prt = prt.next;
        } 

        prt.next = startEven.next;
        return start.next;
        
    }
}

// Better solution

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
