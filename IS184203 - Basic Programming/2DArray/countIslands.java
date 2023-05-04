/**
 * Language/Type: Java     
 *   
 * Write a method named countIslands that accepts a rectangular 2-D array of integers as a
 * parameter, where every integer in the array is either 0 to represent water or 1 to represent
 * land, and returns an integer count of how many contiguous "islands" of land are in the array.
 * An "island" is a connected group of land areas (1) that neighbor each other directly up, down,
 * east, or west (not diagonal). For example, suppose the array contains the following values:
 * 
 * int[][] map = {
 *     {0, 0, 0, 0, 0, 0, 1},
 *     {0, 1, 1, 1, 0, 0, 1},
 *     {0, 0, 0, 1, 0, 0, 0},
 *     {0, 1, 0, 1, 0, 1, 0},
 *     {0, 0, 0, 0, 0, 1, 0},
 *     {0, 1, 1, 0, 0, 1, 0},
 *     {0, 1, 1, 0, 0, 0, 0}
 * };
 * 
 * There are five distinct islands in this array, so the call of countIslands(map) should return 5.
 * 
 * Your code should work for a board of any size, even one with 0 rows or columns. You may
 * assume that the 2-D array is rectangular, that is, that each row of the 2-D array contains the
 * same number of columns. You may assume that no values appear in the array other than 0 and 1.
 */

public class countIslands {
    public static void main(String[] args){
         int[][] map = {
                {0, 0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0}
         };
        
        System.out.println(countIslands(map));
    }

    public static int countIslands(int[][] map){
        if(map.length <= 0){
            return ;
        }
        
        int islandCount = 0;
        for(int i = 0; i < map.length - 1; i++){
            for(int j = 0; j < map[0].length - 1; j++){
                if(map[i][j] == 1){
                    if(map[i + 1][j] == 1){
                        islandCount++;
                        map[i][j] = 0;
                        map[i + 1][j] = 0;
                    } else if(map[i - 1][j] == 1){
                        islandCount++;
                        map[i][j] = 0;
                        map[i - 1][j] = 0;
                    } else if(map[i][j + 1] == 1){
                        islandCount++;
                        map[i][j] = 0;
                        map[i][j + 1] = 0;
                    } else if(map[i][j - 1] == 1){
                        islandCount++;
                        map[i][j] = 0;
                        map[i][j - 1] = 0;
                    }
                }
            }
        }

        return islandCount;
    }

}