//19. Remove Nth Node From End of List - M.
//Given a linked list, remove the n-th node from the end of list and return its head.

import java.util.*;

public class Main {

    //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode start = head;
         ListNode gap = head;
         while (n > 0) {
             gap = gap.next;
             n--;
         }
         if (gap == null) return start.next;
         while (gap.next != null) {
             head = head.next;
             gap = gap.next;
         }
         head.next = head.next.next;
         return start;
    }

    public static void main(String[] args) {

    }
}
