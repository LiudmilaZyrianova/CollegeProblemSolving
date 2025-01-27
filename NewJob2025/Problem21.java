// 21. Merge Two Sorted Lists - E

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode resPoint = new ListNode(0);
        ListNode res = resPoint;
        while ((list1 != null) && (list2 != null)) {
            if (list1.val <= list2.val) {
                resPoint.next = list1;
                list1 = list1.next;
            } else {
                resPoint.next = list2;
                list2 = list2.next;
            }
            resPoint = resPoint.next;
        }

        while (list1 != null) {
            resPoint.next = list1;
            resPoint = resPoint.next;
            list1 = list1.next;
        }
        
        while (list2 != null) {
            resPoint.next = list2;
            resPoint = resPoint.next;
            list2 = list2.next;
        }

        return res.next;
    }

// Optimization: no need for the rest of the program: cur.next = (list1 != null) ? list1 : list2;

// OR!! Do it recursively!!
        if(list1.val<list2.val){
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
