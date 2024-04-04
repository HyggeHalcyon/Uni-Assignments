/*
 * Language/Type: Java   
 * 
 * Write a method named flatten that accepts a 2-D array of integers as a parameter and that
 * returns a 1-D array with the contents of the original 2-D array "flattened" into a one-dimensional
 * array. For example, if the given 2-D array is declared:
 * 
 *  int[][] matrix = {
 *      {  3,   8,  12},
 *      {  2,   9,  17},
 *      { 43,  -8,  46},
 *      {203,  14,  97}
 *  };
 * 
 * Then the call of flatten(matrix) should return the following 1-D array:
 * 
 *  {3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97}
 * 
 * Your code should work for an array of any size, even one with 0 rows or columns. You may
 * assume that the 2-D array is rectangular, that is, that each row of the 2-D array contains the same
 * number of columns. Your method should not modify the array that is passed in.
 */

 import java.util.Arrays;

 public class flatten {
    public static int[] flatten(int[][] matrix){
        if(matrix.length > 0){
            boolean check = true;

            for(int i = 0; i < matrix.length; i++){
                if(matrix[i].length > 0){
                    check = false;
                }
            }

            if(check){
                return new int[0];
            }
        } else if(matrix.length == 0) {
            return new int[0];
        }

        String s = "";

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                s += "" + matrix[i][j] + ",";
            }
        }

        return Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
