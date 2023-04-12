/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 02
 * Student ID       : 5026221079
 * Student Name     : Muhammad Fawwaz Razani
 * Class            : C
 * Cohort           : A
 */

public class Main {

    public static void main(String[] args) {
        //call method defined under main method
        task1();

    }

    public static void task1(){

        //declare and initialize the variables

        int priceOfCoffee = 15000;
        int priceOfTea = 10000;
        int priceOfPizza = 45000;
        char currency = '$';
        int numOfCoffee = 3;
        int numOfTea = 5;
        int numOfPizza = 1;
        String nameOfCustomer = "Albert";

        double discountOfCoffee = 0.1;
        double discountOfTea = 0.15;
        double discountOfPizza = 0.05;
        double tax = 0.11;
        double cashInHand = 200000;

        // count number of items
        int numOfItems = numOfPizza + numOfCoffee + numOfTea;

        // count the total price
        double totalPrice = (priceOfCoffee * numOfCoffee * (1-discountOfCoffee)) + (priceOfTea * numOfTea * (1-discountOfTea)) + (priceOfPizza * numOfPizza * (1-discountOfPizza));
        // count the total price after tax
        double totalPriceAfterTax = totalPrice+(totalPrice*tax);
        // print total price
        System.out.println("Total Price: "+ currency + totalPrice);

        // count the change
        double change =  cashInHand - totalPriceAfterTax;
        //printing the change
        System.out.println("Change: " + currency + change);

        // count amount of donation
        double donation = (change % 1000);
        System.out.println("Donation: " + currency + donation);


        // print the receipt
        System.out.println("-----------------------------------\n");
        System.out.println("Name Of Customer: "+ nameOfCustomer);
        System.out.println("ORDERS");
        System.out.println("Number of items: " + numOfItems);
        System.out.println("Tea \t|\t" + numOfTea + "\t|\t"  + priceOfTea * numOfTea * (1-discountOfTea));
        System.out.println("Coffee\t|\t" + numOfCoffee + "\t|\t"  + priceOfCoffee * numOfCoffee * (1-discountOfCoffee));
        System.out.println("Pizza\t|\t" + numOfPizza + "\t|\t"  + priceOfPizza * numOfPizza * (1-discountOfPizza));
        System.out.println("Total Before Tax: "+ currency + totalPrice);
        System.out.println("Tax: " + tax * 100 + "%");
        System.out.println("Total After Tax: "+ currency + totalPriceAfterTax);
        System.out.println("Amount Paid: "+ currency + cashInHand);
        System.out.println("Change: " + currency + change);
        System.out.println("Donation Amount: " + currency + donation);
        System.out.println("\n-----------------------------------");
    }

}