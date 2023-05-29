/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 10
 * Student ID       : 
 * Student Name     : 
 * Class            : 
 * Cohort           : 
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1(){
        System.out.println(sumOfDigits(412));
    }

    public static int sumOfDigits(int num){

        int div = num / 10;
        int mod = num % 10;

        if(div > 0){
            return mod + sumOfDigits(div);
        } else  {
            return mod;
        }
    }

    public static void task2(){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("Maze.txt"));
        int numRows = Integer.parseInt(scanner.nextLine());
        int numCols = Integer.parseInt(scanner.nextLine());

        char[][] maze = new char[numRows][numCols];

        for(int i = 0; i < numRows; i++){
            String row = scanner.nextLine();
            for(int j = 0; j < numCols; j++){
                maze[i][j] = row.charAt(j);
            }
        }

        System.out.println(explore(0, 0, 0, maze));
    }

    public static int explore(int row, int col, int step, char[][] maze){
        if(row < 0 || col < 0 || row > maze.length - 1 || col > maze[row].length - 1){
            return 1000;
        }

        if(maze[row][col] == 'x'){
            return 1000;
        }

        if(maze[row][col] == 'O'){
            return step;
        }

        maze[row][col] = 'x';

        int up = explore(row - 1, col, step + 1, maze);
        int below = explore(row + 1, col, step + 1, maze);
        int right = explore(row, col + 1, step + 1, maze);
        int left = explore(row, col - 1, step + 1, maze);

        maze[row][col] = '.';

        int distance = Integer.MAX_VALUE;
        if(up < distance) distance = up;
        if(below < distance) distance = below;
        if(right < distance) distance = right;
        if(left < distance) distance = left;

        return distance;
    }

    public static void task3(){
        int money = 100;
        int[] price_list = {100, 20, 35, 45, 12, 15, 81, 23, 75};
        System.out.println(buyStuff(money, price_list, 0));
    }

    public static int buyStuff(int money, int[] price_list, int idx){
        if(money <= 0 || idx >= price_list.length){
            return 0;
        }

        boolean sorted = true;

        // check if all elements are sorted ascendingly
        for(int i = 0; i < price_list.length - 1; i++){
            if(price_list[i] > price_list[i + 1]){
                sorted = false;
                break;
            }
        }

        // sort them by using bubble sort recursion
        if(!sorted){
            idx = idx % (price_list.length - 1);

            int previousElement = price_list[idx];
            int currentElement = price_list[idx + 1];

            boolean swapCheck = (previousElement > currentElement);

            if(swapCheck){
                price_list[idx] = currentElement;
                price_list[idx + 1] = previousElement;
                idx = buyStuff(money, price_list, idx + 1);
            } else {
                idx = buyStuff(money, price_list, idx + 1);
            }
        }

        // if sorted iterate all elements until price accumulated exceeds available money
        if(sorted){
            int accumulatedPrice = 0;
            idx = 0;
            while(accumulatedPrice + price_list[idx] <= money){
                accumulatedPrice += price_list[idx];
                idx++;
            }
            // return number of items
            return idx;
        }

        return idx;
    }
}