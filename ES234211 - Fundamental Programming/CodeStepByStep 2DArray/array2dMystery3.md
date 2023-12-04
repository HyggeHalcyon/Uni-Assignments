### Language/Type: Java      
        
Consider the following method. For each multi-dimensional array listed below, write the final array state that would result if the given array were passed as a parameter to the method.        
```java          
public void array2dMystery3(int[][] a) {         
    for (int r = 0; r < a.length - 1; r++) {         
        for (int c = 0; c < a[0].length - 1; c++) {        
            if (a[r][c + 1] > a[r][c]) {        
                a[r][c] = a[r][c + 1];        
            } else if (a[r + 1][c] > a[r][c]) {        
                a[r][c] = a[r + 1][c];     
            }      
        }      
    }      
}      
```         
```java       
int[][] a1 = {{3, 4, 5, 6}, {4, 2, 6, 1}, {1, 6, 7, 2}};	    
int[][] a2 = {{1, 2, 3, 0, 5}, {2, 4, 6, 8, 10}, {9, 5, 1, 2, 4}};       
```       
### Answer
```java       
int[][] a1 = {{4, 5, 6, 6}, {4, 6, 7, 1}, {1, 6, 7, 2}};     
int[][] a2 = {{2, 3, 6, 5, 5}, {4, 6, 8, 10, 10}, {9, 5, 1, 2, 4}};      
``` 