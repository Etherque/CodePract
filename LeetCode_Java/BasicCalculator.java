/* Implement a basic calculator to evaluate a simple expression string.The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces . 
*/

public class Solution {
    public int calculate(String s) {
       if(s == null || s.length() == 0) return 0;
       int sgn = 1, ans = 0, num = 0;
       Stack<Integer> stk = new Stack<> ();
       
       for(char c : s.toCharArray()) {
          if(c >= '0' && c<= '9') {
              num = num * 10 + c - '0';
          }
          else if(c == '+') {
              ans += sgn * num;
              sgn = 1;
              num = 0;
          }
          else if(c == '-') {
              ans += sgn * num;
              sgn = -1;
              num = 0;
          }
          else if(c == '(') {
              stk.push(ans);
              stk.push(sgn);
              ans = 0;
              sgn = 1;
          }
          else if (c == ')') {
              ans += sgn * num;
              sgn = stk.pop();
              ans = sgn * ans + stk.pop();
              num = 0;
          }
       }
       
       if(num != 0) {
          ans += sgn * num;
       }
       return num;
    }
}