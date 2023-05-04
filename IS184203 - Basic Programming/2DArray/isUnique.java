/*
 * Language/Type: Java   
 * 
 * Write a method named isUnique that accepts a 2-D array of integers as a parameter and that
 * returns a boolean value indicating whether or not the values in the array are unique (true for
 * yes, false for no). The values in the list are considered unique if there is no pair of values that
 * are equal. For example, if a variable called matrix stores the following values:
 * 
 *  int[][] matrix = {{3, 8, 12}, {2, 9, 17}, {43, -8, 46}, {203, 14, 97}};
 * 
 * Then the call of isUnique(matrix) should return true because there are no duplicated values
 * in this array. If instead the array stored these values:
 * 
 * int[][] matrix2 = {{4, 7, 2}, {3, 9, 12}, {-47, -19, 308}, {3, 74, 15}};
 * 
 * Then the call should return false because the value 3 appears twice in this list. Notice that
 * given this definition, an array of 0 or 1 elements would be considered unique. Your code should
 * work for an array of any size, even one with 0 rows or columns.
 * 
 * Constraints: You may use one auxiliary data structure of your choice to help you solve this
 * problem. Your method should not modify the array that is passed in.
 */

public class isUnique {
    public static boolean isUnique(int[][] matrix){
        if(matrix.length > 0){
            boolean check = true;

            for(int i = 0; i < matrix.length; i++){
                if(matrix[i].length > 0){
                    check = false;
                    break;
                }
            }

            if(check){
                return true;
            }
        } else if(matrix.length == 0) {
            return true;
        }
        
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(s.toString().contains(","+matrix[i][j]+",")){
                    return false;
                }
                s.append(","+matrix[i][j]+",");
            }
        }

        return true;
    }
}
