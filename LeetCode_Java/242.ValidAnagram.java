public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        
        for(int i = 0; i < 26; i++) map[i] = 0;
        
        for(char c : s.toCharArray()) map[c - 'a']++;
        
        for(char c : t.toCharArray()) {
            map[c - 'a']--;
        }
        
        for(int i = 0; i< 26; i++){
            if(map[i] != 0) return false;
        }
        return true;
        
    }
}
