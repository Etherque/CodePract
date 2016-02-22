/* Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999. */

public class Solution {
    public String intToRoman(int num) {
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"}; 
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        String res = "";
        int i = 0;
        while(num > 0){
            while(num >= val[i]){
                num -= val[i];
                res += symbol[i];
            }
            i++;
        }
        return res;
    }
}
