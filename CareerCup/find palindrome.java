import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  
  public static boolean hasPalindrome(String s) {
    if(s.length() <= 1 || s == null) 
      return true;
    
    for(int i = 1; i < s.length() - 1; i++) {
      if(s.charAt(i - 1) == s.charAt(i + 1))
        return true;
      if(i <= s.length() - 2 && (s.charAt(i) == s.charAt(i + 1)))
         return true;
      if(s.charAt(i) == s.charAt(i - 1))
        return true;
    }
    return false;
    
  }
  
  public static void main(String[] args) {
    /*
    Find Whether a Input string had Palindrome? 
    Example : 
    Input Samples : "1234xyzyx5678" , "abcdefeabc" 
    }
    */
    String[] cases = {"abbc", "abcc", "1234xyzyx5678", "abcdefeabc"};
    for (String str : cases) {
      System.out.println(str + " " +hasPalindrome(str));
    }
  }
}
