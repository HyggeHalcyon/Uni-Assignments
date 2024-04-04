/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 11
 * Student ID       : .......................
 * Student Name     : .......................
 * Class            : C
 * Cohort           : A
 */
 import java.util.Scanner;
 import java.lang.Math.*;
 import java.io.*;


public class Main {

    public static void main(String[] args) {
        task1();
        task2();
    }


    public static void task1(){

        try{
            String inputFile = "Input.txt"; /* correct file name */
            // String inputFile = "Onput.txt"; /* incorrect file name */
            String outputFile = "output.txt";
            File input = new File(inputFile);
            File output = new File(outputFile);
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);
            byte [] buffer = new byte[1024];
            int bytesRead;

            // while ((bytesRead = fis.read(buffer)) != -1) {
            //     fos.write(buffer, 0, bytesRead);
            // }
            
            bytesRead = fis.read(buffer);
            fos.write(buffer, 0, bytesRead);

        } catch(IOException e) {
                System.out.println(e);
            }
    }
    

	public static void task2(){
        Scanner sc = new Scanner(System.in);
        String c;
        double result;

        System.out.println("Hello welcome simple division calculator :3 \n");

        do{
            System.out.print("Please enter your numerator value : ");
            int numerator = sc.nextInt();
            System.out.print("Next, your denominator pwease >.< : ");
            int denominator = sc.nextInt();
            System.out.println(String.format("Calculating %d divided by %d ... \n", numerator, denominator));

            try{
                result = (double) numerator / denominator; 
                // System.out.println(String.format("The result is..... tada!!! \nResult: %f \n", result));
                System.out.println(String.format("The result is: %f\n", result));
            } catch(ArithmeticException e){
                // System.out.println("Ouh oh, something went wrong. Is it maybe because you tried dividing by 0?");
                System.out.println("Tidak dapat membagi dengan angka 0!");
            }

            System.out.print("Do you still want to continue :^) ? (y/n) \n");
            c = sc.next();
            if(c.equals("n")) break; 
        } while(true);

        System.out.println("\nBye Bye! see u next time :D");
	}


}
