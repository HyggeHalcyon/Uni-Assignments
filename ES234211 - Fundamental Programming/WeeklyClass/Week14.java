import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Week14 {
    public static void latihan1(){
        Scanner sc = new Scanner(System.in);

        int a;
        System.out.print("masukkan angka: ");
        try {
            a = sc.nextInt();
        }catch (InputMismatchException e){
            System.out.println("inputan harus angka");
        }
    }

    public static void latihan2(){
        Scanner sc = new Scanner(System.in);
        int PIN = 1337;
        int input = 0;

        do {
            try {
                System.out.print("Masukkan PIN: ");
                input = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("PIN MUST BE A NUMBER");
                /* why need this? sc.next(); */
                /* https://stackoverflow.com/questions/3572160/how-to-handle-infinite-loop-caused-by-invalid-input-inputmismatchexception-usi */
                sc.next();
            }
        }while(input != PIN);

        System.out.println("Authorized");
    }
}
