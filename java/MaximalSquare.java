//Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

public class Solution {
    public int maximalSquare(char[][] matrix) {
      if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
      int m = matrix.length;
      int n = matrix[0].length;
      
      int[][] dp = new int[m][n];
      for(int i = 0; i < m; i++) {
         dp[i][0] = matrix[i][0] - '0';
      } 
      for(int j = 0; j < n; j++) {
         dp[0][j] = matrix[0][j] - '0';
      }
      
      for(int i = 1; i < m; i++) {
         for(int j = 1; j < n; j++) {
            if(matrix[i][j] == '1') {
               int min = Math.min(dp[i][j - 1], dp[i - 1][j]);
               dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + 1;
            }
            else dp[i][j] = 0;
         }
      }
      
      int max = 0;
      for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
           max = Math.max(dp[i][j], max);
        }
      }
      
      return max * max;
    }
}