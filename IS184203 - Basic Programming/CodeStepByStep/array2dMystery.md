Language/Type: Java

Consider the following method:

public void arrayMystery2D(int[][] numbers) {
    for (int r = 0; r < numbers.length; r++) {
        for (int c = 0; c < numbers[0].length - 1; c++) {
            if (numbers[r][c + 1] > numbers[r][c]) {
                numbers[r][c] = numbers[r][c + 1];
            }
        }
    }
}
If a two-dimensional array numbers is initialized to the following values, what are its contents after the call of arrayMystery2D(numbers); ?

int[][] numbers = {
    {3, 4, 5, 6},
    {4, 5, 6, 7},
    {5, 6, 7, 8}
};
arrayMystery2D(numbers);

Answer:       
row 0	= 4, 5, 6, 6       
row 1	= 5, 6, 7, 7     
row 2	= 6, 7, 8, 8      