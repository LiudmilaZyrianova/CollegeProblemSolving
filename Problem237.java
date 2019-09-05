//237. Delete Node in a Linked List - E.
//Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

public class Main {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

//    The whole point of asking any candidates a linked list problem is to test if the candidates think about edge cases, including:
//
//Dereferencing Null Pointer, usually targeting tail pointer
//When given Head is None
//When there are duplications in the list

//     This question specifically mentioned all the above edge cases and extracted them out for you
    
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {

    }
}
