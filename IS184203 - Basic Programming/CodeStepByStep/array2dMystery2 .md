Language/Type: Java

Consider the following method. For each multi-dimensional array listed below, write the final array state that would result if the given array were passed as a parameter to the method.

public void array2dMystery2(int[][] a) {
    for (int r = 0; r < a.length; r++) {
        for (int c = a[0].length - 2; c > 0; c--) {
            a[r][c] = a[r][c - 1] + a[r][c + 1];
        }
    }
}

int[][] a1 = {{2, 1, 6}, {5, 8, 9}, {1, -5, -4}};	
int[][] a2 = {{1, 2, 3, 4, 5}, {2, 4, 6, 8, 10}, {0, 1, 2, 3, 4}};

Answer:      
int[][] a1 = {{2, 8, 6}, {5, 14, 9}, {1, -3, -4}}
int[][] a2 = {{1, 11, 10, 8, 5}, {2, 22, 20, 16, 10}, {0, 7, 7, 6, 4}};