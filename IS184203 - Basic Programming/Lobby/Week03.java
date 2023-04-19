/*
Project Code:
376845
376862
376879
 */

public class Week03 {
    public static void main1(){
        int a = 10;

        Integer anInteger = 10;
        String aNumber = anInteger.toString();

        String name = "Ahmad";
        name = name.concat(" Zakaria");
        System.out.println(name);
        name = name.toUpperCase();
        System.out.println(name);
    }
    public static void main2() {
        printLogo();
        printLine();
        System.out.println("No. \t item \t\t\t Qty \t price \t total");
        printLine();
        int grandTotal=0;
        grandTotal = grandTotal+countMe(3,12250);
        int total=countMe(3,12250);

        System.out.println("1 \t Hotdog \t\t 3 \t 12250 \t "+total);
        grandTotal = grandTotal+countMe(2,5750);
        System.out.println("2 \t Iced Lemon Tea \t 2 \t 5750 \t "+countMe(2,5750));
        grandTotal = grandTotal+countMe(4,14225);
        System.out.println("3 \t Crips \t\t\t 4 \t 14225 \t "+countMe(4,14225));
        printLine();
        System.out.println("Grand Total:\t\t\t\t\t"+grandTotal);
        printLine();
    }
    public static void printLogo(){
        System.out.println("<h4>Subway Takeaway</h4>");
    }
    public static void printLine(){
        System.out.println("-------------------------------------------------------");
    }
    public static int countMe(int qty, int price){
        return (int) (qty*price*1.11);
    }
    public static String switchNameTwoArg(String firstName, String lastName){
        return lastName + " " + firstName;
    }
    public static String switchNameOneArg(String fullname){
        String firstname = fullname.substring(0, fullname.indexOf(" "));
        String lastname = fullname.substring(fullname.indexOf(" ") + 1);
        return lastname + " " + firstname;
    }

    public static String reverseName(String name){
        name = name.toLowerCase();

        String output = ""+name.toUpperCase().charAt(4);
        output += name.charAt(3);
        output += name.charAt(2);
        output += name.charAt(1);
        output += name.charAt(0);


        return "King " + output;
    }
    public static void main3(String[] args) {
        String myName= "Alice William";
        char x = myName.charAt(10);
        System.out.println(x);

        int idx=myName.indexOf('g',6);
        System.out.println(idx);

        int length = myName.length();
        System.out.println(length);

        System.out.println(myName.toUpperCase());
    }
    public static String reverseName2(String fullName){
        String output="";

        output = output+"King "+(""+fullName.charAt(4)).toUpperCase()+fullName.charAt(3)+fullName.charAt(2)+fullName.charAt(1)+(""+fullName.charAt(0)).toLowerCase();
        output = output.replace("King", "Queen");
        return output;
    }
    public static String romeToArabic(String rome){
        rome = rome.replace("III", "3");
        rome = rome.replace("II", "2");
        rome = rome.replace("IV", "4");
        rome = rome.replace("I", "1");
        rome = rome.replace("V", "5");

        return rome;
    }
}
