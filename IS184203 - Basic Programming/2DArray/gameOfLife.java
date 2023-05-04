/*
 * Language/Type: Java   
 * 
 * Write a method named gameOfLife that performs one update on a Game of Life board
 * represented as a 2D array. Conway's Game of Life is a simple representation of cellular automata
 * behavior using a board of characters representing cells. A given cell can be either alive (1) or
 * dead (0). To update the board, each cell's status should change based on the number of living
 * direct neighbors it has in each of the eight directions. The rules are as follows:   
 * - A living cell with 0 or 1 living neighbors dies from underpopulation.
 * - A living cell with 2 or 3 living neighbors stays alive.
 * - A living cell with more than 3 living neighbors dies from overpopulation.
 * - A dead cell with exactly 3 living neighbors comes to life.
 * 
 * For example, suppose the array contains the following state:
 * 
 * int[][] board = {
 *     {0, 0, 1, 0, 1},
 *     {0, 0, 1, 0, 1},
 *     {0, 0, 1, 0, 0},
 *     {0, 0, 1, 1, 0},
 *     {0, 0, 0, 0, 0},
 * };
 * 
 * Then the call of gameOfLife(board); should modify it to store the following:
 * 
 * {
 *     {0, 0, 0, 1, 0},
 *     {0, 1, 1, 0, 0},
 *     {0, 1, 1, 0, 0},
 *     {0, 0, 1, 1, 0},
 *     {0, 0, 0, 0, 0}
 * }
 * 
 * Your code should work for a board of any size, even one with 0 rows or columns. You may
 * assume that the 2-D array is rectangular, that is, that each row of the 2-D array contains the same
 * number of columns. You may assume that no values appear in the board other than 0 and 1.
 */

public class gameOfLife {
   public static int[][] gameOfLife(int[][] board){
      if(board.length == 0){
         return new int[0][0];
     }

     int row = board.length;
     int column = board[0].length;
     int[][] duplicate = new int[row][column];

     for(int i = 0; i < duplicate.length; i++){
         for(int j = 0; j < duplicate[i].length; j++){
             duplicate[i][j] = board[i][j];
         }
     }

     for(int i = 0; i < duplicate.length; i++){
      for(int j = 0; j < duplicate[0].length; j++){
         
      }
     }

     return board;
   }
}