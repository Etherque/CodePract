/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
         ListNode p = dummy;
        
         while(p.next != null){
            if(p.next.val == val){
                ListNode tmp = p.next;
                p.next = tmp.next;
            }
            else p = p.next;
         }
         return dummy.next;
    }
}
