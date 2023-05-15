/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 09
 * Student ID       : 
 * Student Name     : 
 * Class            : 
 * Cohort           : 
 */

import java.util.Scanner;
import java.lang.*;

public class Main {


    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }


    public static void task1(){
        double r = 5;
        double t = 10;

        Tube tube1 = new Tube(r, t);

        System.out.println("The circumference of the base: " + tube1.baseCircumference());
        System.out.println("The area of the base: " + tube1.baseArea());
        System.out.println("The total surface area of the tube: " + tube1.area());
        System.out.println("The volume of the tube: " + tube1.volume());
    }

    public static void task2(){
        OpoAccount userA = new OpoAccount("12345678", "User A", 100.0);
        OpoAccount userB = new OpoAccount("987654321", "User B",50.0 );

                //User A topUp and transfer to User B
        userA.topUp(200);
        userA.transfer(userB, 150);

        //User B withdraw money their Opo account
        userB.withdraw(100.0);

        // Print account details for both accounts
        System.out.println("Account details for " + userA.getName() + ":");
        System.out.println("Balance: $" + userA.getBalance());
        System.out.println("Points: " + userA.getPoints());
        System.out.println("Transaction History: " + userA.getTransactions());

        System.out.println();

        System.out.println("Account details for " + userB.getName() + ":");
        System.out.println("Balance: $" + userB.getBalance());
        System.out.println("Points: " + userB.getPoints());
        System.out.println("Transaction History: "+userB.getTransactions());

    }


    public static void task3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Monster Battle Warrior II V.2");

        String name;
        System.out.print("Input Player's Name: ");
        name = sc.nextLine();
        Human hooman = new Human(name);
        System.out.print("Input Monster's Name: ");
        name = sc.nextLine();
        Monster monstah = new Monster(name);
        System.out.println("");

        hooman.checkStatus();
        monstah.checkStatus();

        int choice;
        int moves = 0;
        while(true){
            if(moves % 2 == 0) System.out.println("Player's Turn!");
            else System.out.println("Monster's Turn!");
            displayMenu();
            choice = sc.nextInt();

            if( choice == 1){
                if(moves % 2 == 0){
                    if(!monstah.dodgeStatus) monstah.attacked(hooman.attack());
                    else monstah.dodgeAttack(Math.random() < 0.5, hooman.attack());
                }
                else hooman.attacked(monstah.attack());
                moves++;
            } else if ( choice == 2){
                if(moves % 2 == 0) hooman.checkStatus();
                else monstah.checkStatus();
            } else if ( choice == 3){
                if(moves % 2 == 0) System.out.println("Hooman can't dodge lmao :P");
                else monstah.dodgeStatus = true;
                moves++;
            } else {
                System.out.println("Don't dare to run you coward!");
                break;
            }
        }

        System.out.println("\nGame's Over!");
        System.out.println("A total of " + moves + " move(s) is made during this session");
        System.out.println("Come Back Anytime!");
    }

    private static void displayMenu(){
        System.out.println("Menu:");
        System.out.println("(1) Attack");
        System.out.println("(2) Check Status");
        System.out.println("(3) Dodge Next Attack");
        System.out.println("(4) Exit");
    }
}