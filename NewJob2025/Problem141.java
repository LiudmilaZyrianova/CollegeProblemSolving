// 141. Linked List Cycle

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        while ((head.next != null) && (head.val != Integer.MAX_VALUE)) {
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }
        return (head.next != null);
    }

// better solution - use two pointers and faster will catch up with the slower

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;        
    }
