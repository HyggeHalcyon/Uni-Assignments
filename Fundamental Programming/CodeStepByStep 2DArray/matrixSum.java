/*
 * Language/Type: Java   
 * 
 * Write a method named matrixSum that accepts as parameters two 2D arrays of integers, treats
 * the arrays as 2D matrices and adds them, returning the result. The sum of two matrices A and B is
 * a matrix C where for every row i and column j, Cij = Aij + Bij. For example, if A is
 * {{1, 2, 3}, {4, 4, 4}} and B is {{5, 5, 6}, {0, -1, 2}}, the call of matrixSum(a, b)
 * should return {{6, 7, 9}, {4, 3, 6}}. You may assume that the arrays passed as parameters
 * have the same dimensions.
 */

public class matrixSum {
    public static int[][] matrixSum(int[][] a, int[][] b){
        if(a.length == 0 || b.length == 0){
            return new int[0][0];
        }

        int row = a.length;
        int column = a[0].length;

        int[][] c = new int[row][column];

        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[i].length; j++){
                c[i][j] = a[i][j] + b[i][j];
            }
        }

        return c;
    }
}
