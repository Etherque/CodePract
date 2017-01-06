/*
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1) return s;
        
        String res = s.substring(0,1);
        for(int i = 0; i < len; i++){
            String tmp = central(s, i, i);
            if(tmp.length() > res.length()) res = tmp;
            
            tmp = central(s, i, i+1);
            if(tmp.length() > res.length()) res = tmp;
        }
        return res;
    }
    public String central(String s, int begin, int end){
        while(begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)){
            begin--;
            end++;
        }
        return s.substring(begin+1, end);
    }
}
