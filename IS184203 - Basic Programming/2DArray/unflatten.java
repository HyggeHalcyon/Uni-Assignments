/*
 * Language/Type: Java  
 * 
 * Write a method named unflatten that accepts three parameters: a 1-D array of integers, and
 * a number of rows and columns. Your method should convert the 1-D array into a 2-D array with
 * the given number of rows and columns, where values are transferred in row-major order into the
 * two-dimensional array. For example, if the given array is declared:
 * 
 *  int[] a = {3, 8, 12, 2, 9, 17, 43, -8, 46, 203, 14, 97};
 * 
 * Then the call of unflatten(a, 4, 3) should return the following 2-D array:
 * 
 * {{  3,   8,  12},
 *  {  2,   9,  17},
 *  { 43,  -8,  46},
 *  {203,  14,  97}}
 * 
 *  The call of unflatten(a, 6, 2) should return the following 2-D array:
 * 
 *  {{  3,   8},
 *   { 12,   2},
 *   {  9   17},
 *   { 43,  -8},
 *   { 46, 203},
 *   { 14,  97}}
 * 
 * If the array's contents do not fit exactly into a 2-D array of the given dimensions, your method
 * should throw an IllegalArgumentException. Your code should work for an array of any size.
 * Your method should not modify the array that is passed in.
 */

import java.util.Arrays;

public class unflatten {
    public static int[][] unflatten(int[] matrix, int row, int column){
        if(row * column != matrix.length){
            throw new IllegalArgumentException();
        }

        int[][] unflat = new int[row][column];
        int number = 0;
        
        try {
            for(int i = 0; i < unflat.length; i++){
                for(int j = 0; j < unflat[i].length; j++){
                    unflat[i][j] = matrix[number++];
                }
            }
        } catch(Exception err){
            throw new IllegalArgumentException("IllegalArgumentExceptionx");
        }

        return unflat;
    }
}
