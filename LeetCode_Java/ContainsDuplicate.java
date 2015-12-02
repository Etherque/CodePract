public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int x : nums){
            if(!set.add(x)) return true;
        }
        return false;
    }
}
