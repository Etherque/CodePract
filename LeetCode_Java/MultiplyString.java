public class Solution {
    public String multiply(String num1, String num2) {

       StringBuilder ans = new StringBuilder();
       StringBuilder rev1 = new StringBuilder(num1), rev2 = new StringBuilder(num2);
       num1 = rev1.reverse().toString();
       num2 = rev2.reverse().toString();
       
       int n1 = num1.length()-1, n2 = num2.length()-1;
       int ns = n1+n2;
       int car =0;
       
       for(int k = 0; k<=ns; k++){
    	   int ck = 0, sum =0;
    	   for(int i=Math.max(0, k-n2); i<=Math.min(k, n1); i++){
    		   int va = num1.charAt(i)-'0';
        	   int vb = num2.charAt(k-i)-'0';
        	   ck+= va*vb;
           }
    	   
    	   sum = ck + car;
    	   car = sum/10;
    	   ans.append(sum%10);  
       }
       
       while(car>0){
    	   ans.append(car%10);
    	   car/=10;
       }
       ans.reverse();
       String res = ans.toString();
       
       while(res.charAt(0)=='0' && res.length()>1){
    	     res = res.substring(1, res.length());
       }
       return res;
	
    }
}
