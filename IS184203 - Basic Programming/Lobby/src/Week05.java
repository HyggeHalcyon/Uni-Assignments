import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Week05 {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        /*
        int a;
        a = 5;
        System.out.println(a<5);

        System.out.println("Enter your cgpa");
        double cgpa = read.nextDouble();

        System.out.println("Congratulation! you passed");
        String status = "";
        if(cgpa >= 3.81) {
            status = "with distinction";
        }
        System.out.println(status);
        */

        /*
        System.out.println("Enter a number:");
        int number = read.nextInt();
        String output = "";
        int mod = number % 2;

        if (mod == 0) output = "Even Number";
        else output = "Odd Number";

        System.out.println(output);
        */

        /*
        System.out.println("Enter a number:");
        int number = read.nextInt();
        int mod = number % 2;

        String output = (mod == 0)?"Even Number":"Odd Number";

        System.out.println(output);
         */

        /*
        int s1 = read.nextInt();
        int s2 = read.nextInt();
        int s3 = read.nextInt();

        if( s1 == s2 && s2 == s3){
            System.out.println("Segitiga Sama Sisi");
        } else if( s1 != s2 && s2 != s3){
            System.out.println("Segitiga sembarang");
        } else {
            System.out.println("Segitiga Sama Kaki");
        }
        */

        /*
        System.out.println("Enter arabic number [1-5]:");
        int arabic = read.nextInt();
        String output = "";

        switch (arabic){
            case 1:
                output = "I";
                break;
            case 2:
                output = "II";
                break;
            case 3:
                output = "III";
                break;
            case 4:
                output = "IV";
                break;
            case 5:
                output = "V";
                break;
            default:
                output = "Invalid Input";
        }

        System.out.println(output);
        */

        String input = read.nextLine();
        String platCode = input.substring(0, input.indexOf(" "));
        String output = "";

        switch (platCode){
            case "L":
                output = "Surabaya";
                break;
            case "DA":
            output = "Kalimantan Selatan";
                break;
            case "BK":
                output = "Medan";
                break;
            case "BL":
                output = "Aceh";
                break;
            case "DK":
                output = "Bali";
                break;
            case "KT":
                output = "Kalimantan Timur";
                break;
            case "B":
                output = "Jakarta";
                break;
            case "AB":
                output = "Yogyakarta";
                break;
            default:
                output = "undefined";
        }

        System.out.println(output);
    }
}
