public class Solution {
    public int evalRPN(String[] tokens) {
          String str = "+-*/"; 
          Stack<String> stk = new Stack<String>();
          
          int res = 0;
          for(String t : tokens){
              if(!str.contains(t)){
                  stk.push(t);
              }else{
                  int a = Integer.valueOf(stk.pop());
                  int b = Integer.valueOf(stk.pop());
                switch(t){
                    case "+":
                        stk.push(String.valueOf(b+a));
                        break;
                    case "-":
                        stk.push(String.valueOf(b-a));
                        break;
                    case "*":
                        stk.push(String.valueOf(b*a));
                        break;
                    case "/":
                        stk.push(String.valueOf(b/a));
                        break;
                }
              }
          }
          res = Integer.valueOf(stk.pop());
          return res;
    }
}
