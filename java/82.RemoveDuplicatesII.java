public ListNode deleteDuplicatesII(ListNode head) {
    if(head == null || head.next == null) return head;
    
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    
    ListNode p = dummy;
    ListNode q = head;
    
    while(q != null) {
       while(q.next != null && p.next.val == q.next.val) {
         q = q.next;
       }
       if(p.next == q) {
          p = p.next;
       }
       else {
         p.next = q.next;
       }
       
       q = q.next;
    }
    
    return dummy.next;
}

