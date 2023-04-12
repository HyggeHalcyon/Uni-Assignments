/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 08
 * Student ID       : Muhammad Fawwaz Razani
 * Student Name     : 50226221079
 * Class            : C
 * Cohort           : A
 */
import java.util.Scanner;
import java.lang.*;

public class Main {


    public static void main(String[] args) {
        //task1();
        task2();
        //task3();
    }

    static void task1(){

        //read the file
        Scanner sc = new Scanner(Main.class.getResourceAsStream("matrix.txt"));
        //get the number of matrix
        int nm = sc.nextInt();

        //loop for each matrix
        for(int i = 0; i < nm; i++){
            //read the number of row and colomn;
            int row = sc.nextInt();
            int column = sc.nextInt();

            //declare the original matrix
            int [][] matrix = new int[row][column];
            //declare the transpose matrix
            int [][] transposeMatrix = new int[column][row];

            //declare varible to hold the number
            int val;

            //assign the number into the 2D matrix
            for( i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    val = sc.nextInt();
                    matrix[i][j] = val;
                    transposeMatrix[j][i] = val;
                }
            }

            // Print the original matrix
            System.out.println("M:");
            for( i = 0; i < row; i++){
                for(int j = 0; j < column; j++){
                    System.out.print("" + matrix[i][j] + "\t");
                }
                System.out.println();
            }

            // Print the tranpose matrix
            System.out.println("M:");
            for(i = 0; i < column; i++){
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
        for(int n=0;n<t;n++){
            //decalre the needed variable
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
                    minimumRow = yPosPawn;
                    maximumRow = yPosPawn;
                }
            } else if(yPosQueen == yPosPawn) {
                isOneColumn = true;
                isThreatened = true;
                if(xPosPawn > xPosQueen){
                    minimumColumn = xPosQueen;
                    maximumColumn = xPosPawn;
                } else {
                    minimumColumn = xPosPawn;
                    maximumColumn= xPosPawn;
                }
            } else if(Math.abs(yPosPawn - yPosQueen) == Math.abs(xPosPawn - xPosQueen)) {
                isDiagonal = true;
                isThreatened = true;
                if(xPosPawn > xPosQueen){
                    minimumColumn = yPosQueen;
                    maximumColumn = yPosPawn;
                } else {
                    minimumColumn = yPosPawn;
                    maximumColumn= yPosPawn;
                }
            }

            //your code here


            //print the chess board if the pawn is threatened by the queen
            if(isThreatened){
                System.out.println("YES");

                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        //your code goes here
                        if(board[i][j] == 1) System.out.println("Q" + "\t");
                        else if(board[i][j] == 2) System.out.println("P" + "\t");
                        else {
                            if(isOneColumn && j == yPosQueen && i > minimumRow && i < maximumRow) System.out.print("X" + "\t");
                            else if(isOneRow && i == yPosQueen && j > minimumColumn && j < maximumColumn) System.out.print("X" + "\t");
                            else if(isDiagonal && i > minimumRow && i < maximumRow && j > minimumColumn && j > maximumColumn) System.out.print("X" + "\t");
                            else System.out.print("O" + "\t");
                        }

                    }
                    System.out.println();
                }

            } else System.out.println("NO");

        }



    }

    static void task3(){
        //your code goes here
        Scanner sc = new Scanner(Main.class.getResourceAsStream("costmatrix.txt"));
        int testcase = sc.nextInt();
        int count = 1;
        String vocabulary = "XABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 0; i < testcase; i++){

            //Start Examining Matrices
            int cities = sc.nextInt();
            int matrix[][] = new int[cities][cities];

            for(int j = 0; j < cities; j++){
                for(int z = 0; z < cities; j++){
                    matrix[j][z] = sc.nextInt();
                }
            }

            System.out.println("Test Case :" + count);
            for(int j = 0; j <= cities; j++){

                for(int z = 0; z <= cities; j++){
                    if(j ==0 && z ==0){
                        System.out.print(" ");
                    } else if(j == 0){
                        System.out.print(" ");
                    } else if()
                }

                System.out.println();
            }
            System.out.println("Best Route:");

            count++;
        }
    }

}