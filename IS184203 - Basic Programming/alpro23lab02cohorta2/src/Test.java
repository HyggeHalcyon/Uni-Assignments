/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 02
 * Student ID       : 5026221001
 * Student Name     : Viqi Alvianto
 * Class            : A
 * Cohort           : A
 */

// Soal: https://docs.google.com/document/d/1AXLlPcqGcExfEzQGoZa-sWDPgY63nwxZrY5xHVERErQ/edit?usp=sharing

public class Test {

    public static void main(String[] args) {
        // Don't change anything here!
        task1();
    }

    public static void task1() {
        // Your Code Here
        double priceOfChicken = 20.0;
        double priceOfFish = 25.0;
        double priceOfSteak = 30.0;
        char currency = '$';
        int numOfChicken = 10;
        int numOfFish = 15;
        int numOfSteak = 5;
        String nameOfCustomer = "Agung";

        double discountOfChicken = 0.05;
        double discountOfFish = 0.05;
        double discountOfSteak = 0.1;
        double tax = 0.1;
        int cashInHand = 1000;

        //count the subtotal
        double subtotalPrice = (priceOfChicken * numOfChicken * (1 - discountOfChicken)) + (priceOfFish * numOfFish * (1 - discountOfFish)) + (priceOfSteak * numOfSteak * (1 - discountOfSteak));

        //count the VAT
        double valueAddedTax = subtotalPrice * tax;

        //count the donation
        double donation = (cashInHand - (subtotalPrice + valueAddedTax)) % 1;

        //count the amount paid
        String amountPaid = cashInHand + ".00";

        //count the change
        double change = (cashInHand - (subtotalPrice + valueAddedTax)) - donation;

        // print the receipt
        System.out.println("RECEIPT");
        System.out.println("Customer Name: " + nameOfCustomer);
        System.out.println("------------------");
        System.out.println("Chicken x " + numOfChicken + " @ " + currency + priceOfChicken);
        System.out.println("Fish x " + numOfFish + " @ " + currency + priceOfFish);
        System.out.println("Steak x " + numOfSteak + " @ " + currency + priceOfSteak);
        System.out.println("------------------");
        System.out.println("Subtotal = " + currency + subtotalPrice);
        System.out.println("VAT (12%) = " + currency + valueAddedTax);
        System.out.println("Total = " + currency + (valueAddedTax + subtotalPrice));
        System.out.println("------------------");
        System.out.println("Amount Paid = " + currency + amountPaid);
        System.out.println("Donation = " + currency + donation);
        System.out.println("Change = " + currency + change);
        System.out.println("------------------");
        System.out.println("Thank you for dining with us!");
    }
}