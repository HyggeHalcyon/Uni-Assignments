/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 06
 * Student ID       : 5026221079
 * Student Name     : Muhammad Fawwaz Razani
 * Class            : C
 * Cohort           : A
 */
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        task1();
        //task2();
        //task3();
    }

    public static void task1(){

        //getting user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your Fullname \t: ");
        String fullName = sc.nextLine();
        System.out.print("Please input your student id \t: ");
        String studentID = sc.nextLine();

        //generating output
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("<b>Academic Report</b>");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Student ID.:" + studentID + "\t\t\tFullname:" + fullName);
        System.out.println("===============================================================================");
        System.out.println("<b>No.\tCode\tName\t\t\t\tCredit\tGrade\tScore\tW.Score</b>");

        //creating a variable of type Scanner
        Scanner scFile = new Scanner(Main.class.getResourceAsStream("transcript.csv"));
        //declare variable to read file per line
        String line;
        //declare array variable of String
        String[] lineSplit;

        //initialize varibles to store credits, total credits, and total to 0
        int credit = 0;
        int totalCredit = 0;
        double totalScore = 0;

        //declare and initialize the variables
        int no = 0;
        String code;
        String course;
        String grade;
        double score;
        double wscore;

        // read the file from beginning to the end

        while(scFile.hasNext()){
            //read the current line
            line = scFile.nextLine();
            //split the current line by comma and save to an array variables
            lineSplit = line.split(",");
            System.out.println(lineSplit);

            code = lineSplit[0];
            course = lineSplit[1];
            credit = Integer.parseInt(lineSplit[2]);
            grade = lineSplit[3];

            //update the total credit by adding the current line credit
            totalCredit = credit + totalCredit;

            score= convertGradeToNumeric(grade);
            wscore = score * credit;
            //update the total score by adding the current line weighted score
            totalScore =  wscore + totalScore;

            //print out the current line
            System.out.println( no + "\t" + code + "\t" + course + "\t\t" + credit + "\t" + grade + "\t" + score + "\t" + wscore);
            //update varible no by 1
            no++;

        }
        System.out.println("-------------------------------------------------------------------------------");

        double cgpa = totalScore / totalCredit;
        String category = "";
        if ( cgpa >= 2.0 )  category="passed";
        else category = "failed";

        System.out.println("\t\t\t CGPA \t:<b>"+ cgpa +" ("+category+")</b>");
        System.out.println("-------------------------------------------------------------------------------");


    }

    public static double convertGradeToNumeric(String grade){
        switch(grade){
            case "A":
                return 4.0;
            case "AB":
                return 3.5;
            case "B":
                return 3.0;
            case "BC":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.5;
            case "E":
                return 1.0;
        }
        return 0.0;
    }

    public static void task2(){

        //read the problem.txt file
        Scanner sc = new Scanner(Main.class.getResourceAsStream("problem.txt"));

        //read the number of accounts
        int account = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < account; i++){
            // count the follower and following
            String accountDetails = sc.nextLine();
            int following = Integer.parseInt(accountDetails.substring(0, accountDetails.indexOf(" ")));
            int followers = Integer.parseInt(accountDetails.substring(accountDetails.indexOf(" ")+1));
            //generate output
            if( followers > 1000 && followers > (10 * following) ){
                System.out.println("FAMOUS");
            } else {
                System.out.println("ORDINARY");
            }
        }
    }

    public static void task3(){
        //Scanner and Variable Declaration
        Scanner scan = new Scanner(Main.class.getResourceAsStream("receipt.txt"));
        String input, productName;
        int totalItems, price = 0;
        double totalShirtPrice = 0;
        int totalShirtCount = 0;
        double totalPantsPrice = 0;
        int totalPantsCount = 0;
        double totalHatPrice = 0;
        int totalHatCount = 0;
        double totalBagPrice  = 0;
        int totalBagCount  = 0;
        double totalOthersPrice = 0;
        int totalOthersCount  = 0;
        double totalPrice = 0;
        double discount = 0;

        //Categorizing Logic
        while(scan.hasNextLine()) {
            input = scan.nextLine();
            productName = input.substring(0, input.indexOf(","));
            price = Integer.parseInt(input.substring(input.indexOf(", ") + 2));

            if(productName.contains("Shirt")){
                totalShirtCount += 1;
                totalShirtPrice += price;
            } else if(productName.contains("Pants")){
                totalPantsCount += 1;
                totalPantsPrice += price;
            } else if(productName.contains("Hat")){
                totalHatCount += 1;
                totalHatPrice += price;
            } else if(productName.contains("Bag")){
                totalBagCount += 1;
                totalBagPrice += price;
            } else {
                totalOthersCount += 1;
                totalOthersPrice += price;
            }
        }

        //Summary Logic
        totalItems = totalShirtCount + totalPantsCount + totalHatCount + totalBagCount + totalOthersCount;
        totalPrice = totalShirtPrice + totalPantsPrice + totalHatPrice + totalBagPrice + totalOthersPrice;
        if(totalPrice > 1000000){
            discount = totalPantsPrice - (totalPantsPrice - 100000) * (1 - 0.05);
            totalPantsPrice = (totalPantsPrice - 100000) * (1 - 0.05);
            totalPrice = totalShirtPrice + totalPantsPrice + totalHatPrice + totalBagPrice + totalOthersPrice;
        }

        //output
        System.out.println("Receipt");
        System.out.println("Category Name\t | \tCount \t | \tSubtotal");
        System.out.println("Shirt\t\t | \t" + totalShirtCount + "\t | \t" + totalShirtPrice);
        System.out.println("Pants\t\t | \t" + totalPantsCount + "\t | \t" + totalPantsPrice);
        System.out.println("Hat\t\t | \t" + totalHatCount + "\t | \t" + totalHatPrice);
        System.out.println("Bag\t\t | \t" + totalBagCount + "\t | \t" + totalBagPrice);
        System.out.println("Others\t\t | \t" + totalOthersCount + "\t | \t" + totalOthersPrice);
        System.out.println("Total Item: " + totalItems);
        System.out.println("Total Price: " + totalPrice);
        System.out.println("You Saved " + discount + ":)");
    }
}