/*
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
           long ans = 0;
           while(x > 0){
                 ans = ans * 10 + x % 10;
                 x /= 10;
           }
           if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
           else return (int) ans;
    }
}
