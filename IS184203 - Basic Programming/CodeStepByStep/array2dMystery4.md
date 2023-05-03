Language/Type: Java       

Consider the following method. For each multi-dimensional array listed below, write the final array state that would result if the given array were passed as a parameter to the method.      
   
public void array2dMystery4(int[][] a) {    
    for (int r = 1; r < a.length - 1; r++) {
        for (int c = 1; c < a[0].length - 1; c++) {
            int sum1 = a[r - 1][c - 1] + a[r + 1][c + 1];
            int sum2 = a[r - 1][c + 1] + a[r + 1][c - 1];
            if (sum1 > sum2) {
                a[r][c] = sum1;
            } else {
                a[r][c] = sum2;
            }
        }
    }
}


int[][] a1 = {
    {3, 4, 5, 6, 2},
    {4, 2, 6, 1, 3},
    {5, 7, 4, 9, 1},
    {1, 6, 7, 2, 8}
};	
int[][] a2 = {
    {0, 1, 0, 1, 0, 1},
    {2, 1, 2, 1, 2, 1},
    {0, 5, 0, 5, 0, 5},
    {3, 2, 3, 2, 3, 2},
    {1, 4, 1, 4, 1, 4}
};

sum1 = 3 + 4
sum2 = 5 + 6

Answer:
int[][] a1 = {
    {3, 4, 5, 6, 2}, 
    {4, 10, 13, 6, 3},
    {5, 14, 12, 21, 1},
    {1, 6, 7, 2, 8}
}
int[][] a2 = {
    {0, 1, 0, 1, 0, 1},
    {2, 0, 6, 0, 6, 1},
    {0, 9, 2, 9, 3, 5},
    {3, 3, 13, 4, 13, 2},
    {1, 4, 1, 4, 1, 4}
}