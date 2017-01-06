/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newhead = null;
        ListNode current = head;
        while(current!= null){
            ListNode tmp = current;
            current = current.next;
            tmp.next = newhead;
            newhead = tmp;
        }
        return newhead;
    }
}
