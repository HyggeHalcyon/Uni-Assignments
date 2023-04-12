/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 05
 * Student ID       : 5026221079
 * Student Name     : Muhammad Fawwaz Razani
 * Class            : C
 * Cohort           : A
 */

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //task1();
        //task2();
        task3();
    }

    public static void task1(){
        System.out.println("===========================================");
        System.out.println("<b> Alpro Medical Diagnostic Centre</b>");
        System.out.println("-------------------------------------------");

        //getting user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your name : ");
        String name = sc.nextLine();

        System.out.print("Please input your sex ( m / f ) : ");
        String sex = sc.nextLine();

        System.out.print("Please input your height ( cm ) : ");
        int height = sc.nextInt();
        sc.nextLine();

        System.out.print("Please input your weight ( kg ) : ");
        int weight = sc.nextInt();
        sc.nextLine();

        //generating output
        System.out.println("-------------------------------------------");


        String salutation;
        if(sex.equals("m"))
        {
            salutation = "Mr";
        } else {
            salutation = "Ms";
        }

        //computing Body Mass Index (BMI)
        double heightInMeter = height/100.0;
        double bmi = weight / (heightInMeter * heightInMeter);
        String bmiCategory;

        // Based on https://www.siloamhospitals.com/en/informasi-siloam/artikel/cara-menghitung-bmi
        if(bmi < 18.5)
        {
            bmiCategory = "underweight";
        } else if (bmi < 25)
        {
            bmiCategory = "normal";
        } else if (bmi < 30)
        {
            bmiCategory = "overweight";
        } else {
            bmiCategory = "obese";
        }

        System.out.println("Customer Name\t: " + salutation + " " + name);
        System.out.println("BMI\t\t: "+ bmi);
        System.out.println("Category\t: <b><font color='b'>" + bmiCategory + "</b></font>");
        System.out.println("===========================================");

    }

    public static void task2(){
        System.out.println("============================================");
        System.out.println("<b> Alpro Medical Diagnostic Centre</b>");
        System.out.println("--------------------------------------------");

        //declare a varible sc as Scanner data type
        Scanner scan = new Scanner(System.in);

        //get customer name
        System.out.print("Please input your name\t: ");
        String name = scan.nextLine();

        //get customer age
        System.out.print("Please input your age\t: ");
        int age = scan.nextInt();

        //Define readFile variable as Scanner data type to read file
        Scanner readFile = new Scanner(Main.class.getResourceAsStream("medicalcheckupresult.txt"));

        //read line 1 until read 4
        String line1 = readFile.nextLine();
        String line2 = readFile.nextLine();
        String line3 = readFile.nextLine();
        String line4 = readFile.nextLine();

        //read the blood glucose level
        int glucose = Integer.parseInt(line3.substring(line3.indexOf(':') + 1, line3.length() - 6));

        //determing the blood glucose category
        String glucoseCategory="";
        // Based on https://www.siloamhospitals.com/informasi-siloam/artikel/kenali-kadar-gula-darah-normal-berdasarkan-usia
        if(age < 6)
        {
            if(glucose >= 100 && glucose <= 200)
            {
                glucoseCategory = "Normal";
            } else {
                glucoseCategory = "Abnormal";
            }
        } else if (age <= 12)
        {
            if(glucose >= 70 && glucose <= 150)
            {
                glucoseCategory = "Normal";
            } else {
                glucoseCategory = "Abnormal";
            }
        } else{
            if(glucose <= 100)
            {
                glucoseCategory = "Normal";
            } else {
                glucoseCategory = "Abnormal";
            }
        }

        //read the cholesterol
        int cholesterol = Integer.parseInt(line4.substring(line4.indexOf(":")+1, line4.length() - 6));
        String cholesterolCategory="";
        // Adult based on https://www.honestdocs.id/kadar-kolesterol-normal-total-hdl-ldl-tg
        if(age > 20)
        {
            if(cholesterol < 200)
            {
                cholesterolCategory = "Normal";
            } else if(cholesterol < 240) {
                cholesterolCategory = "Borderline";
            } else {
                cholesterolCategory = "High";
            }
        } else {
            if(cholesterol <= 170)
            {
                cholesterolCategory = "Normal";
            } else if(cholesterol < 200) {
                cholesterolCategory = "Borderline";
            } else {
                cholesterolCategory = "High";
            }
        }

        //generating output
        System.out.println("-------------------------------------------");
        System.out.println("<b>Medical Checkup Results: </b>");
        System.out.println("Cust. Name\t: " + name + " (" + age +" yo)");
        System.out.println("1.Blood Glucose\t: " + glucose +" <b><font color='blue'>(" + glucoseCategory +")</font></b>");
        System.out.println("2.Cholesterol \t: " + cholesterol +" <b><font color='red'>("+ cholesterolCategory +")</font></b>");
        System.out.println("============================================");
    }

    public static void task3(){
        Scanner scan = new Scanner(System.in);
        Scanner read = new Scanner(Main.class.getResourceAsStream("receipt.txt"));

        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.print("Enter your membership category (None/Silver/Gold/Platinum): ");
        String membership = scan.nextLine();

        String line1 = read.nextLine();
        String line2 = read.nextLine();
        String line3 = read.nextLine();
        String line4 = read.nextLine();
        String line5 = read.nextLine();
        String line6 = read.nextLine();

        double discount;
        if(membership.equals("None")){
            discount = 0;
        } else if(membership.equals("Silver")){
            discount = 5.0;
        } else if(membership.equals("Gold")){
            discount = 10.0;
        } else {
            discount = 15.0;
        }

        int toothpastePrice = Integer.parseInt(line3.substring(line3.indexOf(" ") + 1));
        int shampooPrice = Integer.parseInt(line4.substring(line4.indexOf(" ") + 1));
        int bodysoapPrice = Integer.parseInt(line5.substring(line5.indexOf(" ") + 1));
        int facewashPrice = Integer.parseInt(line6.substring(line6.indexOf(" ") + 1));
        double totalPurchase = toothpastePrice + shampooPrice + bodysoapPrice + facewashPrice;
        double discountedPurchase = totalPurchase * ( 1 - (discount / 100));
        int coupons = (int) discountedPurchase / 25000;

        System.out.println("Hi, " + name + "!");
        System.out.println("Since you are a " + membership + " member, you get a " + discount + "% discount.");
        System.out.println("Your total purchase value is Rp" + totalPurchase + ".");
        System.out.println("You need to pay Rp" + discountedPurchase + ".");
        System.out.println("Congrats! You get " + coupons + " coupons.");
    }
}
