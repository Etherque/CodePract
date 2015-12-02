/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode first = head;
        ListNode second = slow.next;
        
        while(second.next != null) {
            ListNode tmp = second.next;
            second.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
        }
        
        while(slow.next != null) {
            slow = slow.next;
            if(slow.val != first.val) return false;
            first = first.next;
        }
        return true;
        
    }
}
