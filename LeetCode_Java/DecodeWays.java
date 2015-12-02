/*
 Given an encoded message containing digits, determine the total number of ways to decode it.
 For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 The number of ways decoding "12" is 2.
*/

public class Solution {
   public int numDecodings(String s) {
      if(s == null || s.length() == 0 || s.equals("0")) return 0;
      int[] results = new int[s.length() + 1];
      results[0] = 1;
      
      if(isValid(s.substring(0, 1))results[1] = 1;
      else results[1] = 0;
      
      for(int i = 2; i <= s.length(); i++) {
         if(isValid(s.substring(i - 1, i)) results[i] += results[i - 1];
         if(isValid(s.substring(i - 2, i)) results[i] += results[i - 2];
      }
      
      return results[s.length()];
   }
   
   public boolean isValid(String str) {
      if(str.charAt(0) == '0') return false;
      int val = Integer.parseInt(str);
      return val >=0 && val <= 26;
   }
}
