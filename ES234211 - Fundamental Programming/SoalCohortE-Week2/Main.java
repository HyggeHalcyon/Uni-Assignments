/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 02
 * Student ID       : 
 * Student Name     : 
 * Class            : C
 * Cohort           : E
 */

public class Main {
    public static void main(String[] args) {
        task1();
    }

    public static void task1(){
        //Price Variable Declaration
        int initialBurgerPrice = 7000;
        int initialFriesPrice = 3000;
        int initialSoftDrinksPrice = 4000;
        char currency = '$';
        double taxPercentage = 0.13;
        int smallestChange = 1000;

        //Summer Sale
        double burgerSale = 0.15;
        double friesSale = 0.2;
        double softDrinksSale = 0.1;

        //Orders
        int burgerOrder = 2;
        int friesOrder = 3;
        int softDrinksOrder = 4;
        double CashGiven = 50000.0;

        //Logic
        double totalBurgerPrice = initialBurgerPrice * burgerOrder * (1 - burgerSale);
        double totalFriesPrice = initialFriesPrice * friesOrder * (1 - friesSale);
        double totalSoftDrinksPrice = initialSoftDrinksPrice * softDrinksOrder * (1 - softDrinksSale);

        double totalBeforeTax = totalBurgerPrice + totalFriesPrice + totalSoftDrinksPrice;
        double tax = totalBeforeTax * taxPercentage;
        double totalAfterTax = totalBeforeTax + tax;
        double change = CashGiven - totalAfterTax;
        double donation = smallestChange - (totalAfterTax % smallestChange);

        //Output
        System.out.println("----------------------------");
        System.out.println("Bob\'s Deli Receipt");
        System.out.println("-----------------------------");
        System.out.println("Number of Burgers: " + burgerOrder);
        System.out.println("Number of Fries: " + friesOrder);
        System.out.println("Number of Soft Drinks: " + softDrinksOrder);
        System.out.println("Total Price before Tax: " + currency + totalBeforeTax);
        System.out.println("Tax: " + currency + tax);
        System.out.println("Total Price after Tax: " + currency + totalAfterTax);
        System.out.println("Amount Paid: " + currency + CashGiven);
        System.out.println("Change: " + currency + change);
        System.out.println("Donated Amount: " + currency + donation);
        System.out.println("-----------------------------");
        System.out.println("Thank you for choosing Bob's Deli!");
    }

}