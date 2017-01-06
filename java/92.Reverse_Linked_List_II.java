/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode mpre = dummy;
        for(int i = 0; i< m-1; i++){
            mpre = mpre.next;
        }
        //now the mhead.next is the start to reverse 
        ListNode now = mpre.next;
        
        for(int i = 0; i<n-m; i++){
            ListNode tmp = now.next;
            now.next = tmp.next;
            tmp.next = mpre.next;//remember not use tmp.next = now
            mpre.next = tmp;
        }
        return dummy.next;
    }
}
