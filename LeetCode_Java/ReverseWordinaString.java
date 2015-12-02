/*
 Given an input string, reverse the string word by word.
 For example, Given s = "the sky is blue", return "blue is sky the"
*/

public class Solution {
   public String reverseWord(String s) {
       if(s == null || s.length() == 0) return s;
       
       StringBuilder sb = new StringBuilder();
       int tail, head;
       
       for(int i = s.length() - 1; i >= 0; i--) {
           while(i >= 0 && s.charAt(i) == ' ') {
             i--;
           }
           
           if(i < 0) break;
           tail = i; head = i;
           
           while(i >= 0 && s.charAt(i) != ' ') {
              head = i--;
           }
           
           if(head <= tail && sb.length() > 0) sb.append(' ');
           sb.append(s, head, tail + 1);
       }
       return sb.toString();
   }
}