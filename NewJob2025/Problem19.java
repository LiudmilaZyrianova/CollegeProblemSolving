//  19. Remove Nth Node From End of List - M
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head.next;
        int slowIdx = 1;
        int fastIdx = 2;
        while ((fast != null) && (fast.next != null)) {
            slow = slow.next; slowIdx++;
            fast = fast.next.next; fastIdx +=2;
        }

        if (fast == null) {
            fastIdx --;
        }

        n = fastIdx - n;
        if (n == 0) return head.next;

        if (n >= slowIdx) {
            while (n > slowIdx) {
                slow = slow.next;
                n--;
            }
            slow.next = slow.next.next;
            return head;
        } else {
            slow = head; 
            while (n > 1) {
                slow = slow.next;
                n--;
            }
            slow.next = slow.next.next;
            return head;
        }
        
    }

// better solution - just move the gap!!
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        while (head != null) {
            head = head.next;
            dummy = dummy.next;
        }

        dummy.next = dummy.next.next;

        return res.next;        
    }
