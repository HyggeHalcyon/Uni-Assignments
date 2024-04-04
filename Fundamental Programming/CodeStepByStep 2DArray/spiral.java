/*
 * Language/Type: Java   
 * 
 * Write a method named spiral that accepts a 2-D array of integers as a parameter and that
 * returns a 1-D array with the contents of the original 2-D array in the order they would appear if
 * visited in a "spiral" order, clockwise starting from top-left. For example, if the given 2-D array is
 * declared:
 * 
 *  int[][] matrix = {
 *      { 1,  2,  3,  4,  5},
 *      { 6,  7,  8,  9, 10},
 *      {11, 12, 13, 14, 15},
 *      {16, 17, 18, 19, 20},
 *  };
 * 
 * Then the call of spiral(matrix) should return the following 1-D array:
 * 
 *  {1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12}
 * 
 * You may assume that the 2-D array is rectangular, that is, that each row of the 2-D array contains
 * the same number of columns. You may also assume that the 2-D array contains at least one row
 * and column. Your method should not modify the array that is passed in.
 */
public class spiral{
    int[] spiral(int[][] matrix){
        
        int rowUpLimit = matrix.length-1;
        int columnUpLimit = matrix[0].length-1;
        int rowLowLimit = 0;
        int columnLowLimit = 0;
        int indexSort = 0;
        
        int[] spiral = new int[matrix.length*matrix[0].length];
        
        while((rowUpLimit > rowLowLimit || rowUpLimit == rowLowLimit) && (columnUpLimit > columnLowLimit || columnUpLimit == columnLowLimit)){
            if(rowUpLimit == rowLowLimit){
                for(int i = columnLowLimit; i<=columnUpLimit; i++){
                    spiral[indexSort] = matrix[rowLowLimit][i];
                    indexSort++;
                }
            break;
            }
            else if(columnUpLimit == columnLowLimit){
                for(int j = rowLowLimit; j<=rowUpLimit; j++){
                    spiral[indexSort] = matrix[j][columnUpLimit];
                    indexSort++;
                }
            columnUpLimit -= 1;            
            break;
            }
            for(int i = columnLowLimit; i<=columnUpLimit; i++){
                spiral[indexSort] = matrix[rowLowLimit][i];
                indexSort++;
            }
            rowLowLimit += 1;
            for(int j = rowLowLimit; j<=rowUpLimit; j++){
                spiral[indexSort] = matrix[j][columnUpLimit];
                indexSort++;
            }
            columnUpLimit -= 1;
            for(int k = columnUpLimit; k>=columnLowLimit; k--){
                spiral[indexSort] = matrix[rowUpLimit][k];
                indexSort++;
            }
            rowUpLimit -= 1;
            for(int l = rowUpLimit; l>=rowLowLimit; l--){
                spiral[indexSort] = matrix[l][columnLowLimit];
                indexSort++;
            }
            columnLowLimit += 1;
        }
        return spiral;
    }
}