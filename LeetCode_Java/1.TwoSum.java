/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]

*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        
        HashMap<Integer, Integer> map = new HashMap<> ();
        for(int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && map.get(nums[i]) != i) { //mark this line: remember map.get[] can not be same as i
                ans[0] = Math.min(i, map.get(nums[i])) + 1;
                ans[1] = Math.max(i, map.get(nums[i])) + 1;
            }
        }
        return ans;
    }
}
