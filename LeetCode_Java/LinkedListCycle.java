//Given a linked list, determine if it has a cycle in it.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       ListNode fast = head;
       ListNode slow = head;
       
       while(fast != null) {
          slow = slow.next;
          fast = fast.next == null ? fast.next : fast.next.next;
          if(fast != null && slow == fast) {
            return true;
          }
       }
       return false;
    }
}