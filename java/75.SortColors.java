public class Solution {
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for(int i = 0; i <= blue; ) {
            if(nums[i] == 0) swap(nums, red++, i++);
            else if(nums[i] == 2) swap(nums, blue--, i);
            else i++;
        }
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[j];
        A[j] = A[i];
        A[i] = tmp;
    }
}
