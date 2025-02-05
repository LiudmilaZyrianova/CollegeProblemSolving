// 148. Sort List - M
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while ((fast.next != null) && (fast.next.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;
        fast = head;


        fast = sortList(fast);
        slow = sortList(slow);

        head = fast;
        ListNode headCopy = new ListNode();
        head = headCopy;

        while ((fast != null) && (slow != null)) {
            if (fast.val < slow.val) {
                head.next = fast;
                fast = fast.next;
            } else {
                head.next = slow;
                slow = slow.next;
            }
            head = head.next;
        }

        if ((fast != null)) {
            head.next = fast;
        } else if ((slow != null)) {
            head.next = slow;
        }

        return headCopy.next;
    }
