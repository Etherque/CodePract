public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null) return head;
    
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    
    ListNode p = head;
    
    while(p.next != null) {
       if(p.val == p.next.val) {
         p.next = p.next.next;
       }
       else p = p.next;
    }
    
    return dummy.next; 
}
