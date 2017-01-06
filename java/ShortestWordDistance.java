/* Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list. word1 and word2 may be the same and they represent two individual words in the list.For example,Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
    Given word1 = “makes”, word2 = “coding”, return 1.
    Given word1 = "makes", word2 = "makes", return 3.
*/

public class Solution {
   public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = Integer.MAX_VALUE;
        int x1 = -1, x2 = -1;
        
        for(int i = 0; i < words.length; i++) {
           if(words[i].equals(word1)) {
              x1 = i;
              if(x2 >= 0) dist = Math.min(dist, Math.abs(x1 - x2));
           }
           if(words[i].equals(word2)) {
              if(word1.equals(word2)) x1 = x2;
              x2 = i;
              if(x1 >= 0) dist = Math.min(dist, Math.abs(x1 - x2));
           }
        }
        if(x1 >= 0 && x2 >= 0) return dist;
        else return 0;
   }
}