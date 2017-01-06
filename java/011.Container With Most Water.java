/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        if(height.length == 0 || height == null) return res;
        int sta = 0, end = height.length-1;
        
        while(sta < end){
            int tmp = Math.min(height[sta], height[end])*(end-sta);
            res = Math.max(res, tmp);
            
            if(height[sta]<height[end]){
                sta++;
            }else{
                end--;
            }
        }
        return res;
    }
}
