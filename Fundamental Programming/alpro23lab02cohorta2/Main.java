/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 02
 * Student ID       : 
 * Student Name     : 
 * Class            : C
 * Cohort           : A
 */

// Soal: https://docs.google.com/document/d/1AXLlPcqGcExfEzQGoZa-sWDPgY63nwxZrY5xHVERErQ/edit?usp=sharing

public class Main {

    public static void main(String[] args) {
        // Don't change anything here!
        task1();
    }

    public static void task1(){

        // Price Variable Declaration
        double ChickenPrice = 20;
        double FishPrice = 25;
        double SteakPrice = 30;
        char Currency = '$';

        // Discounts
        double ChickenFishCombo = 0.05;
        double SteakCombo = 0.1;

        // Input Data
        String RecipientName = "Agung";
        int numOfChicken = 10;
        int numOfFish = 15;
        int numOfSteak = 5;
        double RecipientCash = 1000;
        double tax = 0.1;
        int SmallestChange = 1;

        // Price Logic
        double TotalChickenPrice = ChickenPrice * numOfChicken * (1 - ChickenFishCombo);
        double TotalFishPrice = FishPrice * numOfFish * (1 - ChickenFishCombo);
        double TotalSteakPrice = SteakPrice * numOfSteak * (1 - SteakCombo);

        double Subtotal = TotalChickenPrice + TotalFishPrice + TotalSteakPrice;
        double VAT = Subtotal * tax;
        double Total = Subtotal + VAT;
        double Donation = SmallestChange - (Total % SmallestChange);
        double Change = RecipientCash - (Total + Donation);

        //Output
        System.out.println("RECEIPT");
        System.out.println("Customer Name: " + RecipientName);
        System.out.println("------------------");
        System.out.println("Chicken x " + numOfChicken + " @ " + Currency + ChickenPrice);
        System.out.println("Fish x " + numOfFish + " @ " + Currency + FishPrice);
        System.out.println("Steak x " + numOfSteak + " @ " + Currency + SteakPrice);
        System.out.println("------------------");
        System.out.println("Subtotal = " + Currency + Subtotal);
        System.out.println("VAT (12%) = " + Currency + VAT);
        System.out.println("Total = " + Currency + Total);
        System.out.println("------------------");
        System.out.println("Amount Paid = " + Currency +  String.format("%.2f", RecipientCash));
        System.out.println("Donation = " + Currency + Donation);
        System.out.println("Change = " + Currency + Change);
        System.out.println("------------------");
        System.out.println("Thank you for dining with us!");
    }
}
