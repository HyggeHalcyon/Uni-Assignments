/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 08
 * Student ID       : 
 * Student Name     : 
 * Class            : C
 * Cohort           : A
 */
import java.util.Scanner;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    static void task1(){

        //read the file
        Scanner sc = new Scanner(Main.class.getResourceAsStream("matrix.txt"));
        //get the number of matrix
        int nm = sc.nextInt();

        //loop for each matrix
        for(int m = 0; m < nm; m++){
            //read the number of row and column;
            int row = sc.nextInt();
            int column = sc.nextInt();

            //declare the original matrix
            int [][] matrix = new int[row][column];
            //declare the transpose matrix
            int [][] transposeMatrix = new int[column][row];

            //declare varible to hold the number
            int val;

            //assign the number into the 2D matrix
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    val = sc.nextInt();
                    matrix[i][j] = val;
                    transposeMatrix[j][i] = val;
                }
            }

            // Print the original matrix
            System.out.println("M:");
            for(int i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    System.out.print("" + matrix[i][j] + "\t");
                }
                System.out.println();
            }

            // Print the tranpose matrix
            System.out.println("M':");
            for(int i = 0; i < column; i++){
                for(int j = 0; j < row; j++){
                    System.out.print("" + transposeMatrix[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    static void task2(){
        //read the input file and the number of test case
        Scanner sc = new Scanner(Main.class.getResourceAsStream("board.txt"));
        int t = sc.nextInt();

        //loop for each test case
        for(int n = 0; n < t; n++){
            //declare the needed variable
            int xPosQueen = 0;
            int yPosQueen = 0;
            int xPosPawn = 0;
            int yPosPawn = 0;
            int board[][] = new int[8][8];

            //loop to assign the number into 2D array and find the position of queen and Pawn
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    //your code goes here
                    board[i][j] = sc.nextInt();

                    if(board[i][j] == 1){
                        xPosQueen = j;
                        yPosQueen = i;
                    } else if(board[i][j] == 2) {
                        xPosPawn = j;
                        yPosPawn = i;
                    }

                }
            }

            //decalare any required variables here
            boolean isThreatened = false;
            boolean isOneColumn = false;
            boolean isOneRow = false;
            boolean isDiagonal = false;
            int minimumColumn = 0;
            int maximumColumn = 0;
            int minimumRow = 0;
            int maximumRow = 0;

            //check whether the pawn is threatened or not
            if(xPosQueen == xPosPawn){
                isOneColumn = true;
                isThreatened = true;
                if(yPosPawn > yPosQueen){
                    minimumRow = yPosQueen;
                    maximumRow = yPosPawn;
                } else {
                    maximumRow = yPosQueen;
                    minimumRow = yPosPawn;
                }
            } else if(yPosQueen == yPosPawn) {
                isOneRow = true;
                isThreatened = true;
                if(xPosPawn > xPosQueen){
                    minimumColumn = xPosQueen;
                    maximumColumn = xPosPawn;
                } else {
                    maximumColumn = xPosQueen;
                    minimumColumn= xPosPawn;
                }
            } else if(Math.abs(yPosPawn - yPosQueen) == Math.abs(xPosPawn - xPosQueen)) {
                isDiagonal = true;
                isThreatened = true;
                if(xPosPawn > xPosQueen){
                    minimumColumn = xPosQueen;
                    maximumColumn = xPosPawn;
                } else {
                    maximumColumn = xPosQueen;
                    minimumColumn= xPosPawn;
                }

                if(yPosPawn > yPosQueen){
                    minimumRow = yPosQueen;
                    maximumRow = yPosPawn;
                } else {
                    maximumRow = yPosPawn;
                    maximumRow = yPosQueen;
                }
            }

            //your code here


            //print the chess board if the pawn is threatened by the queen
            if(isThreatened){
                System.out.println("YES");
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        //your code goes here
                        if(board[i][j] == 1)
                            System.out.print("Q" + "\t");
                        else if(board[i][j] == 2)
                            System.out.print("P" + "\t");
                        else {
                            if(isOneColumn && j == xPosQueen && i > minimumRow && i < maximumRow)
                                System.out.print("X" + "\t");
                            else if(isOneRow && i == yPosQueen && j > minimumColumn && j < maximumColumn)
                                System.out.print("X" + "\t");
                            else if(isDiagonal && i > minimumRow && i < maximumRow && j > minimumColumn && j < maximumColumn && Math.abs(i - xPosPawn) == Math.abs(j - yPosPawn))
                                System.out.print("X" + "\t");
                            else
                                System.out.print("O" + "\t");
                        }
                    }
                    System.out.println();
                }
            } else System.out.println("NO");

        }
    }

    public static int cost = 0;
    public static String path = "";
    static void task3(){
        //your code goes here
        //Variable Declaration
        Scanner sc = new Scanner(Main.class.getResourceAsStream("costmatrix.txt"));
        int testcase = sc.nextInt();
        String vocabulary = "XABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 1; i <= testcase; i++){
            //Matrix Dimension Declaration
            int numOfCities = sc.nextInt();
            int cityMap[][] = new int[numOfCities + 1][numOfCities + 1];

            //Filling in Matrix with values
            for(int j = 0; j <= numOfCities; j++){
                for(int z = 0; z <= numOfCities; z++){
                    cityMap[j][z] = sc.nextInt();
                }
            }

            //Output:
            //Iteration of test cases
            System.out.println("Test Case :" + i);
            //Mapping the cities with its corresponding cost
            for(int j = 0; j <= numOfCities + 1; j++) {
                for (int z = 0; z <= numOfCities + 1; z++) {
                    if (j == 0 && z == 0) {
                        System.out.print("  ");
                    } else if (j == 0) {
                        System.out.print(vocabulary.charAt(z - 1) + " ");
                    } else if (z == 0) {
                        System.out.print(vocabulary.charAt(j - 1) + " ");
                    } else {
                        for (int m = 0; m <= numOfCities; m++) {
                            System.out.print(cityMap[j - 1][m] + " ");
                        }
                        break;
                    }
                }
                System.out.println();
            }

            //Analyzing its best routes
            //recursive goes here
            boolean[] v = new boolean[numOfCities + 1];
            v[0] = true;
            int ans = Integer.MAX_VALUE;
            ans = tsp(cityMap, v, 0, numOfCities + 1, 1, 0, ans, "");

            // Prints out its Best Route
            System.out.print("Best Route:X--");
            for(int j = 0; j < Main.path.length(); j++) System.out.print(Main.path.charAt(j) + "--");
            System.out.println("X (" + Main.cost + ")");
        }
    }

    static int tsp(int[][] graph, boolean[] v, int currPos, int numOfCities, int count, int cost, int ans, String path) {
        String vocabulary = "XABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // If last node is reached and it has a link
        // to the starting node i.e the source then
        // keep the minimum value out of the total cost
        // of traversal and "ans"
        // Finally return to check for more possible values
        if (count == numOfCities && graph[currPos][0] > 0) {
            //ans = Math.min(ans, cost + graph[currPos][0]);
            if(ans > cost + graph[currPos][0]){
                ans = cost + graph[currPos][0];
                Main.path = path;
                return ans;
            } else {
                return ans;
            }
        }

        // BACKTRACKING STEP
        // Loop to traverse the adjacency list
        // of currPos node and increasing the count
        // by 1 and cost by graph[currPos,i] value
        for (int i = 0; i < numOfCities; i++) {
            if (v[i] == false && graph[currPos][i] > 0) {
                // Mark as visited
                v[i] = true;
                ans = tsp(graph, v, i, numOfCities, count + 1, cost + graph[currPos][i], ans, path + "" + vocabulary.charAt(i));
                // Mark ith node as unvisited
                v[i] = false;
            }
        }
        Main.cost = ans;
        return ans;
    }
}


/*  OLD ALG NOT ACCURATE
    System.out.println(recurveCount);
    System.out.println(numOfCitiesLeft);
    System.out.println(rowIndex);
    System.out.println(path);

    int cost = 0;
    int nodeIndex = 0;
    for(int j = 0; j <= numOfCities; j++){
        int minCost = Integer.MAX_VALUE;
        int minCostIndex = 0;

    if(j == numOfCities){
        cost += cityMap[nodeIndex][0];
        break;
    }

    for(int z = 0; z < cityMap[nodeIndex].length; z++){
        if(cityMap[nodeIndex][z] < minCost && !bestRoutes.contains("" + vocabulary.charAt(z)) ){
            minCost = cityMap[nodeIndex][z];
            minCostIndex = z;
        }
    }

    cost += cityMap[nodeIndex][minCostIndex];
    bestRoutes += vocabulary.charAt(minCostIndex) + "--";

    nodeIndex = minCostIndex;
*/
