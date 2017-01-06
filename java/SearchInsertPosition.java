/* Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order. You may assume no duplicates in the array.
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
       int len = nums.length;
       
       int l = 0, r = len - 1;
       while(l <= r) {
           int m = (l + r) / 2;
           if(target < nums[m]) {
              r = m - 1;
           }
           else if(target > nums[m]) {
              l = m + 1;
           }
           else return m;
       }
       
       return l;
    
    }
}