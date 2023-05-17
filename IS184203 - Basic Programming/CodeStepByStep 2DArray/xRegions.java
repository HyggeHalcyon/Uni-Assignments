/*
 * Language/Type: Java  
 * 
 * Write a method named xRegions that accepts a rectangular 2-D array of characters as a
 * parameter, where every character in the array is guaranteed to be either an uppercase 'X' or
 * dash '-', and modify its state so that any dashes or groups of dashes that are entirely
 * surrounded by Xes in the original array will be changed to 'X' themselves. For example, suppose
 * the array contains the following characters:
 * 
 * char[][] board = {
 *     {'X', 'X', 'X', 'X', 'X', 'X', '-'},
 *     {'X', '-', '-', '-', 'X', 'X', 'X'},
 *     {'X', 'X', 'X', '-', 'X', 'X', 'X'},
 *     {'X', '-', 'X', '-', 'X', '-', 'X'},
 *     {'X', 'X', 'X', 'X', 'X', '-', 'X'},
 *     {'X', '-', '-', 'X', 'X', '-', 'X'},
 *     {'X', '-', '-', 'X', 'X', 'X', 'X'}
 * };
 * 
 * Then the call of xRegions(board); should modify it to store the following:
 * 
 * {
 *     {'X', 'X', 'X', 'X', 'X', 'X', '-'},
 *     {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
 *     {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
 *     {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
 *     {'X', 'X', 'X', 'X', 'X', 'X', 'X'},
 *     {'X', '-', '-', 'X', 'X', 'X', 'X'},
 *     {'X', '-', '-', 'X', 'X', 'X', 'X'}
 * }
 * 
 * Notice that two groups of dashes are not changed to 'X': the ones that touch the top-right and
 * bottom borders of the array.
 * 
 * Your code should work for a board of any size, even one with 0 rows or columns. You may
 * assume that the 2-D array is rectangular, that is, that each row of the 2-D array contains the same
 * number of columns. You may assume that no characters appear in the board other than 'X' and '-'.
 */


public class xRegions {
    public static int[][] xRegions(int[][] board){
        
    }
}