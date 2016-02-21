
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        boolean[] letter = new boolean[256];
        int l = 0, max = 0;
        
        for(int r = 0; r < s.length(); r++) {
            if(!letter[s.charAt(r)]) letter[s.charAt(r)] = true;
            else {
                while(s.charAt(l) != s.charAt(r)) {
                    letter[s.charAt(l)] = false;
                    l++;
                }
                l++;
            }
            
            max = Math.max(max, r - l + 1);
        }
        
        return max;
    }
}
