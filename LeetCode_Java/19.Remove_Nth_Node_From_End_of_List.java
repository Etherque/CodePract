/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        
        ListNode sec = head;
        for(int i = 0; i < n; i++){
            sec = sec.next;
        }
        if(sec == null) return head.next; // find the n-1 th from the end
        
        ListNode fir = head;
        while(sec.next != null){
            fir = fir.next;
            sec = sec.next;
        }
        
        fir.next = fir.next.next;
        return head;
        
    }
}
