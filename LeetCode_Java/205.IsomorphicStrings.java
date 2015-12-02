public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<> ();
        
        for(int i = 0; i< s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            if(map.containsKey(cs)) {
                if(map.get(cs) != ct) return false;
            }
            
            else {
                if (!map.containsValue(ct)) map.put(cs, ct);
                else return false;
            }
        }
        return true;
    }
}
