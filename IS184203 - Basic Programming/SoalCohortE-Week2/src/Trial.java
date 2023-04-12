/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 02
 * Student ID       : 5026221040
 * Student Name     : Alif Faturrohman
 * Class            : C
 * Cohort           : E
 */

public class Trial {
    public static void main(String[] args) {
        task1();
    }

    public static void task1(){
        //write your code here
        char currency = '$';

        int priceOfBurgers = 7000;
        int priceOfFries = 3000;
        int priceOfSoftDrinks = 4000;

        double discountOfBurgers = 0.15;
        double discountOfFries = 0.2;
        double discountOfSoftDrinks = 0.1;

        int numOfBurgers = 2;
        int numOfFries = 3;
        int numOfSoftDrinks = 4;

        double cashInHand = 50000.0;
        double tax = 0.13;

        double totalPrice = priceOfBurgers * (1 - discountOfBurgers) * numOfBurgers + priceOfFries * (1 - discountOfFries) * numOfFries + priceOfSoftDrinks * (1 - discountOfSoftDrinks) * numOfSoftDrinks;
        double totalPriceAfterTax = totalPrice * (1 + tax);
        double change = cashInHand - totalPriceAfterTax;
        double donation = change % 1000;

        System.out.println("----------------------------");
        System.out.println("Bob's Deli Receipt");
        System.out.println("----------------------------");
        System.out.println("Number of Burgers: " + numOfBurgers);
        System.out.println("Number of Fries: " + numOfFries);
        System.out.println("Number of Soft Drinks: " + numOfSoftDrinks);
        System.out.println("Total Price before Tax: " + currency + totalPrice);
        System.out.println("Tax: " + currency + tax * totalPrice);
        System.out.println("Amount Paid: " + currency + cashInHand);
        System.out.println("Change: " + currency + change);
        System.out.println("Donated Amount: " + currency + donation);
        System.out.println("----------------------------");
        System.out.println("Thank you for choosing Bob's Deli!");

    }

}