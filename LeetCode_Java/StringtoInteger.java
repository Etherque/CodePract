public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        
        char sgn = '+'; int i = 0;
        if(str.charAt(0) == '+') i++;
        else if(str.charAt(0) == '-') {
            sgn = '-'; i++;
        } 
        double res = 0; //long type would not be enough for digits
        while(str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        if(sgn == '-') res = -res;
        if(res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)res;
    }
}
