//Given an absolute path for a file (Unix-style), simplify it.

public class Solution {
    public String simplifyPath(String path) {
       StringBuilder sb = new StringBuilder();
       if(path == null || path.length()) return sb.toString();
       
       String[] strs = path.split("/");
       Stack<String> stk = new Stack<> ();
       
       for(String s : strs) {
          if(s.length() || s.equals(".")) continue;
          else if(s.equals("..")) {
              if(!stk.isEmpty()) stk.pop();
          }
          else stk.push(s);
       }
       if(stk.isEmpty()) {
           sb.append('/');
       }
       else {
           while(!stk.isEmpty()) {
              sb.insert(0, stk.pop());
              sb.insert(0, '/');
           }
       }
       return sb.toString();
    }
}