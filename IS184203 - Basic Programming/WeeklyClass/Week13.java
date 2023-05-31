import javax.swing.*;

public class Week13 {
    public static void main(String[] args) {
        printStar(20);
        System.out.println();
        recursivePrintStar(20);
        printBinary(163);
    }

    static void printStar(int n){
        for(int i=0;i<n;i++) System.out.print("*");
    }

    static void recursivePrintStar(int n){
        if (n==1) System.out.print("*");
        else {
            System.out.print("*");
            recursivePrintStar(n-1);
        }
    }

    public static void printBinary(int n){
        if(n < 0){
            System.out.print("-");
            n = n * (-1);
        }
        if (n == 0) System.out.print(0);
        else if (n == 1) System.out.print(1);
        else {
            printBinary(n / 2);
            System.out.print( n % 2);
        }
    }

    public static void printRange(int x, int y){
        if (x > y) throw new IllegalArgumentException();
        if (x == y) System.out.print(x);
        else if (y - x == 1) System.out.print(x + " -- " + y);
        else {
            System.out.print(x + " > ");
            printRange(x + 1, y - 1);
            System.out.print(" < " + y);
        }
    }
}
