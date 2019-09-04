//234. Palindrome Linked List - E.
//Given a singly linked list, determine if it is a palindrome.
import java.util.*;

public class Main {
    
    //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

     //Better solution!!
//    public boolean isPalindrome(ListNode head) {
//        ListNode fast = head, slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        if (fast != null) { // odd nodes: let right half smaller
//            slow = slow.next;
//        }
//        slow = reverse(slow);
//        fast = head;
//
//        while (slow != null) {
//            if (fast.val != slow.val) {
//                return false;
//            }
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return true;
//    }
//
//    public ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = prev;
//            prev = head;
//            head = next;
//        }
//        return prev;
//    }
    public static boolean isPalindrome(ListNode head) {
         Stack<Integer> s = new Stack<>();
         ListNode start = head;
         while (head != null) {
             s.push(head.val);
             head = head.next;
         }
        while (start != null) {
            if (start.val != s.peek()) return false;
            s.pop();
            start = start.next;
        }
         return true;

    }

    public static void main(String[] args) {

    }
}
