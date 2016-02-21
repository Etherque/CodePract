/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();
		int len = s.length();
		if(len<numRows || s==null || numRows==1) return s;
		int stair = 2*(numRows-1);
		for(int k = 0; k<numRows; k++){
			int ix = k, in = stair -k;
			
			if(k==0 || k== numRows-1){
				while(ix<len){
					ans.append(s.charAt(ix));
					ix+=stair;
				}
			}else{
				while(ix<len || in <len){
					if(in<len){
						ans.append(s.charAt(ix));
						ans.append(s.charAt(in));
						ix+=stair;
						in+=stair;
					}else{
						ans.append(s.charAt(ix));
						ix+=stair;
					}
					//System.out.println(in+ans.toString());
				}
			}
		}
		return ans.toString();
    }
}
