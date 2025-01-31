// 2. Add Two Numbers - M
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = l1;
        int overflow = 0;
        int res = 0;
        while ((l1.next != null) && (l2.next != null)) {
            res = l1.val + l2.val + overflow;
            l1.val = res % 10;
            overflow = res / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        res = l1.val + l2.val + overflow;
        l1.val = res % 10;
        overflow = res / 10;

        if (l2.next != null) {
            l1.next = l2.next;
        }

        while (l1.next != null) {
            l1 = l1.next;
            res = l1.val + overflow;
            l1.val = res % 10;
            overflow = res / 10;
        }

        if (overflow == 1) {
            l1.next = new ListNode(1);
        }

        return start;
    }

// Prettier solution - do || conditions
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode res = dummy;
        int total = 0, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

            if (l1 != null) {
                total += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                total += l2.val;
                l2 = l2.next;
            }

            int num = total % 10;
            carry = total / 10;
            dummy.next = new ListNode(num);
            dummy = dummy.next;
        }

        return res.next;        
    }
