/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        ListNode tailA = null, tailB = null;
        
        while(true){
            
            if(pA == null) pA = headB;
            if(pB == null) pB = headA;
            
            if(pA.next == null) tailA = pA;
            if(pB.next == null) tailB = pB;
            
            if(tailA != null && tailB != null && tailA != tailB) return null;//judge the tail
            
            if(pA == pB) return pA;
            
            pA = pA.next;
            pB = pB.next;
        }
    }
}
