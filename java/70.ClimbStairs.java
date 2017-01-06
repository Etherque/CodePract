public class Solution {
    public int climbStairs(int n) {
    if(n <= 2) return n;
    int[] s = new int[n + 1];
    for(int i = 0; i < n + 1; i++){
       if(i <= 2) s[i] = i;
       else s[i] = s[i - 1] + s[i - 2];       
    }
    return s[n];
}
