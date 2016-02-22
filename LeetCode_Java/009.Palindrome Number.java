/*
Determine whether an integer is a palindrome. Do this without extra space.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int digit = 1;
        while(x / digit >= 10) digit *= 10;
        while(x > 0){
            int head = x / digit;
            int tail = x % 10;
            if(head != tail) return false;
            x = (x % digit)/10;
            digit /= 100;//very important
        }
        return true;
    }
}
