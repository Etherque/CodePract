/* Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.*/

public class Solution {
    public int romanToInt(String s) {
        if(s == null) return 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i > 0 && c2n(s.charAt(i)) > c2n(s.charAt(i - 1))) {
                ans += c2n(s.charAt(i)) - 2 * c2n(s.charAt(i - 1));
            }
            else {
                ans += c2n(s.charAt(i));
            }
        }
        return ans;
    }
    public int c2n(char c){
        switch(c) {  
          case 'I': return 1;
          case 'V': return 5;
          case 'X': return 10;
          case 'L': return 50;
          case 'C': return 100; 
          case 'D': return 500; 
          case 'M': return 1000; 
      } 
      return 0;
    }
}
