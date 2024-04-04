/*
 * Language/Type: Java  
 * 
 * Write a method named zeroRowCol that accepts a 2-D array of integers as a parameter and
 * modifies its contents by setting any element value to 0 if there is a 0 in that row and/or in that
 * column. For example, if a variable called matrix stores the following values:
 * 
 * int[][] matrix = {{ 0,  1,  4,  0},
 *                   { 3,  2,  6,  4},
 *                   {-1,  3,  1,  8},
 *                   {15,  7,  2,  0},
 *                   { 9,  4,  5,  6}};
 * 
 * Then the call of zeroRowCol(matrix) should modify its state to be the following:
 * 
 *                  {{ 0,  0,  0,  0},
 *                   { 0,  2,  6,  0},
 *                   { 0,  3,  1,  0},
 *                   { 0,  0,  0,  0},
 *                   { 0,  4,  5,  0}}
 * 
 * Your code should work for an array of any size, even one with 0 rows or columns.
 */

public class zeroRowCol {
    public static int[][] zeroRowCol(int[][] matrix){
        if(matrix.length == 0){
            return new int[0][0];
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int[][] zero = new int[row][column];

        for(int i = 0; i < zero.length; i++){
            for(int j = 0; j < zero[i].length; j++){
                zero[i][j] = matrix[i][j];
            }
        }

        for(int i = 0; i < zero.length; i++){
            for(int j = 0; j < zero[i].length; j++){
                if(zero[i][j] == 0){
                    for(int n = 0; n < zero[i].length; n++){
                        matrix[i][n] = 0;
                    }
                    for(int n = 0; n < zero.length; n++){
                        matrix[n][j] = 0;
                    }
                }
            }
        }
        return matrix;
    }
}