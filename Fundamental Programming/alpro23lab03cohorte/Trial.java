/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 03
 * Student ID       :
 * Student Name     :
 * Class            :
 * Cohort           :
 */

public class Trial {

    public static void main(String[] args) {


        // Do not change

        task1("Rahman Arif/17-02-2003/Jakarta/M/A/WNI/Single");
        //task1("Alice Rebecca/17-03-1984/London/F/O/WNA/Married");
        task2("Wanda");
        task3("11+88");
    }

    public static String task1(String data){
        // Your code here
        // ...

        int startPosition = 0;
        //find the first slash position within string stored in variable named data
        int slashPosition = data.indexOf("/");
        //chop the string from the beginning to the first slash position (/ is excluded)
        String name = data.substring(startPosition, slashPosition);
        //split and reverse the name to correct firstname and lastname order
        String firstName= name.substring(name.indexOf(" ")+1, name.length());
        String lastName= name.substring(startPosition, name.indexOf(" "));
        //get the first character of first and last name
        String initial = ""+ firstName.charAt(startPosition) + lastName.charAt(startPosition);

        //chop the string stored in variable named data from the first slash (excluded) to the end
        data = data.substring(slashPosition + 1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the date of birth dd-mm-yyyy
        String birthDate = data.substring(startPosition, slashPosition);
        //chop the year of birth yyyy
        String birthYear = birthDate.substring(birthDate.length() - 4);
        //count the age
        int age = 2023 - (Integer.parseInt(birthYear));

        //chop the string stored in variable named data from the second slash (excluded) to the end
        data = data.substring(slashPosition+1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the palce of birth
        String birthPlace = data.substring(startPosition, slashPosition);

        //chop the string stored in variable named data from the third slash (excluded) to the end
        data = data.substring(slashPosition+1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the sex data M or F
        String sex = data.substring(startPosition, slashPosition);
        //change M to Male and F to Female
        sex = sex.replace("M","Male");
        sex = sex.replace("F", "Female");

        //chop the string stored in variable named data from the fourth slash (excluded) to the end
        data = data.substring(slashPosition + 1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the blood type data
        String bloodType = data.substring(startPosition, slashPosition);

        //chop the string stored in variable named data from the fifth slash (excluded) to the end
        data = data.substring(slashPosition + 1);
        //find the position of the next slash
        slashPosition = data.indexOf("/");
        //chop the citizenship data
        String citizen = data.substring(startPosition, slashPosition);
        //check whether local citizen
        boolean isLocalCitizenB = citizen.equalsIgnoreCase("WNI");
        //change true or false to Yes or No
        String isLocalCitizen =""+ isLocalCitizenB;
        isLocalCitizen = isLocalCitizen.replace("true","Yes");
        isLocalCitizen = isLocalCitizen.replace("false", "No");

        //chop the string stored in variable named data from the sixth slash (excluded) to the end
        data = data.substring(slashPosition + 1);
        //chop the marital status data
        String maritalStatus = data;

        //generating the output
        String line1 = "Full Name: " + firstName + " "+lastName+ " (" + initial + ")";
        String line2 = "Age: " + age;
        String line3 = "City of Birth: " + birthPlace;
        String line4 = "Sex: " + sex;
        String line5 = "Blood Type: " + bloodType;
        String line6 =  "Local Citizen: " + isLocalCitizen;
        String line7 = "Marital Status: " + maritalStatus;

        //store the output to variable named output
        String output = line1 + "\n" + line2 + "\n" + line3+ "\n" + line4 + "\n" + line5 + "\n" + line6 + "\n" + line7 + "\n";

        //print out the output
        System.out.println(output);

        return output;
    }


    public static String task2(String name){
        // Your code here
        // ...

        //store all alphabet to single string
        //each alphabet with its index: a -> 0, b->1. ... z ->25
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        //change the input to lowercase, since tha alphabets are all in lowercase
        name = name.toLowerCase();

        //set the key

        int key = 5;

        //shift each character to 5 places right, if more than 25 then it back to 0
        String k1 = ""+ alphabet.charAt((alphabet.indexOf(name.charAt(0))+ key) % 26);
        String k2 = ""+ alphabet.charAt((alphabet.indexOf(name.charAt(1))+ key) % 26);
        String k3 = ""+ alphabet.charAt((alphabet.indexOf(name.charAt(2))+ key) % 26);
        String k4 = ""+ alphabet.charAt((alphabet.indexOf(name.charAt(3))+ key) % 26);
        String k5 = ""+ alphabet.charAt((alphabet.indexOf(name.charAt(4))+ key) % 26);

        //change the first character to upper case
        k1 = k1.toUpperCase();

        //generate the output
        String output = k1 + k2 + k3 + k4 + k5;

        //print out the output
        System.out.println(output + "\n");

        //return the output
        return output;
    }


    public static String task3(String NumberOp){
        // Your code here
        // ...

        String output="" + (Integer.parseInt(NumberOp.substring(0, NumberOp.indexOf("+"))) + Integer.parseInt(NumberOp.substring(NumberOp.indexOf("+") + 1 )));
        String partA="" + output.substring(0, output.length()-1);
        String partB="" + output.substring(output.length()-1);

        //you should need method defined below to convert from number to text e.g. 1--> satu, 2--> dua
        output = readIt(partA)+" puluh"+readIt(partB);
        System.out.println(readIt(partA));

        return output;
    }

    static String readIt(String input) {
        //your code goes here
        input = input.replace("1", " satu");
        input = input.replace("2", " dua");
        input = input.replace("3", " tiga");
        input = input.replace("4", " empat");
        input = input.replace("5", " lima");
        input = input.replace("6", " enam");
        input = input.replace("7", " tujuh");
        input = input.replace("8", " delapan");
        input = input.replace("9", " sembilan");
        input = input.replace("0", "");


        return input;
    }

}