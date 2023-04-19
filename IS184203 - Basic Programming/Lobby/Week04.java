import javax.swing.*;
import  java.util.Scanner;
public class Week04 {
    public static void main(String[] args){
        //gettingUserInput();
        userInterface();
    }
    public static void gettingUserInput(){
        //read from keyboard
        Scanner scan = new Scanner(System.in);

        System.out.println("Please, enter your name: ");
        String name = scan.nextLine();

        System.out.println("Please, enter your income: ");
        int income = scan.nextInt();

        System.out.println("Please, enter your tax (%): ");
        double tax = scan.nextDouble();

        System.out.println("Hi <b>" + name + "</b>!\nWelcome onboard");
        System.out.println("Your tax is <b><font color='red'>" + (tax / 100.0 * income) + "</font></b>\nThank you :)");

        //read from file
        Scanner read = new Scanner(Main.class.getResourceAsStream("input.txt"));
        String saving = read.nextLine();
        System.out.println("Your saving money is: " + saving);
        String deposit = read.nextLine();
        System.out.println("Your saving money is: " + deposit);
    }

    public static void userInterface(){
        JOptionPane ui = new JOptionPane();
        Scanner read = new Scanner(Week04.class.getResourceAsStream("input.txt"));

        String saving = read.nextLine();
        String name = ui.showInputDialog("Please enter your name: ");
        String incomeS = ui.showInputDialog("Please enter your income: ");
        String taxS = ui.showInputDialog("please enter your tax");

        int income = Integer.parseInt(incomeS);
        double tax = Double.parseDouble(taxS);
        String output = "Hi " + name + "\nWelcome onboard!"
                                     + "\nyour tax is " + (tax / 100 * income)
                                     + "\nyour saving is " + saving;

        ui.showMessageDialog(null, output, "Welcome Board", 1); //tryout messageType 1-3
    }

}
