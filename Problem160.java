//160. Intersection of Two Linked Lists - E.
//Write a program to find the node at which the intersection of two singly linked lists begins.

public class Main {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    // Better solution
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        //boundary check
//        if(headA == null || headB == null) return null;
//
//        ListNode a = headA;
//        ListNode b = headB;
//
//        //if a & b have different len, then we will stop the loop after second iteration
//        while( a != b){
//            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
//            a = a == null? headB : a.next;
//            b = b == null? headA : b.next;
//        }
//
//        return a;
//    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if (headA == null || headB == null) return null;
         ListNode startB = headB;
         while (headA != null) {
             while (headB != null) {
                 if (headA == headB) return headA;
                 headB = headB.next;
             }
             headA = headA.next;
             headB = startB;
         }
         return null;
    }

    public static void main(String[] args) {

    }
}
