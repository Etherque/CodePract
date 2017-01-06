/*Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'
A region is captured by flipping all 'O's into 'X's in that surrounded region.
*/

public class Solution {
   //record the 'O' postion with a Queue
   private static Queue<Integer> queue = new LinkedList<> (); 
   public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i < row; i++) {
            if(board[i][0] == 'O') bfs(i, 0, board);
            if(board[i][col - 1] == 'O') bfs(i, col - 1, board);
        }
        
        for(int j = 0; j < col; j++) {
            if(board[0][j] == 'O') bfs(0, j, board);
            if(board[row - 1][j] == 'O') bfs(row - 1, j, board);
        }
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
              if(board[i][j] == 'O') {
                 board[i][j] = 'X';
              }
              
              if(board[i][j] == '#') {
                 board[i][j] = 'O';
              }
            }
        }
   }
   
   private static void fill(int i, int j, char[][] board) {
        int row = board.length;
        int col = board[0].length;
        if(i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O') return;
        
        queue.add(i * col + j);
        board[i][j] = ’#‘；
   }
   
   private static void bfs(int i, int j, char[][] board) {
        int col = board[0].length;
        fill(i, j , board);//fill the board[i][j] with 'O'
        
        while(!queue.isEmpty()) {
           int cur = queue.poll();
           int x = cur / col;
           int y = cur % col;
           
           fill(x - 1, y, board);
           fill(x + 1, y, board);
           fill(x, y - 1, board);
           file(x, y + 1, board);
        }
   }
}
