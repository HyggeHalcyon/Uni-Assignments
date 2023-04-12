/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 03
 * Student ID       : 5026221079
 * Student Name     : Muhammad Fawwaz Razani
 * Class            : C
 * Cohort           : A
 */

public class Main {

    public static void main(String[] args) {
        // Do not change

        task1("Rahman Arif/17-02-2003/Jakarta/M/A/WNI/Single");
        //task1("Alice Rebecca/17-03-1984/London/F/O/WNA/Married");
        //task2("Wanda");
        //task3("11+88");
    }

    public static String task1(String data){
        // Your code here
        // ...

        int startPosition = 0;
        //find the first slash position within string stored in variable named data
        ___ slashPosition = ___.indexOf("/");
        //chop the string from the beginning to the first slash position (/ is excluded)
        ___ name = data.___(startPosition, slashPosition);
        //split and reverse the name to correct firstname and lastname order
        String firstName=___.substring(name.indexOf(" ")+1, ___);
        string lastName=___;
        //get the first character of first and last name
        ___ initial = ""+ ___ + ___;

        //chop the string stored in variable named data from the first slash (excluded) to the end
        data = ___.substring(slashPosition+1);
        //find the position of the next slash
        slashPosition = ___
        //chop the date of birth dd-mm-yyyy
        String birthDate = ___
        //chop the year of birth yyyy
        String birthYear = ___;
        //count the age
        ___ age = ___ - (Integer.parseInt(___));

        //chop the string stored in variable named data from the second slash (excluded) to the end
        data = ___
        //find the position of the next slash
        slashPosition =___
        //chop the palce of birth
        String birthPlace =___;

        //chop the string stored in variable named data from the third slash (excluded) to the end
        data = ___
        //find the position of the next slash
        slashPosition = ___
        //chop the sex data M or F
        String sex = ___
        //change M to Male and F to Female
        sex= sex.replace(___,___);
        ___= ___

        //chop the string stored in variable named data from the fourth slash (excluded) to the end
        data = ___
        //find the position of the next slash
        slashPosition = ___
        //chop the blood type data
        string bloodType = ___

        //chop the string stored in variable named data from the fifth slash (excluded) to the end
        data = ___
        //find the position of the next slash
        slashPosition = ___
        //chop the citizenship data
        String citizen = ___;
        //check whether local citizen
        boolean isLocalCitizenB = citizen.___(___);
        //change true or false to Yes or No
        String isLocalCitizen =""+___;
        isLocalCitizen = isLocalCitizen.replace(___,___);
        isLocalCitizeN = ___

        //chop the string stored in variable named data from the sixth slash (excluded) to the end
        data = ___
        //chop the marital status data
        String maritalStatus = ___

        //generating the output
        String line1 = "Full Name: " + firstName + " "+lastName+ " (" + initial + ")";
        String line2 = "Age: " + ___;
        String line3 = "City of Birth: " + ___;
        String line4 = "Sex: " +___;
        String ___ = "Blood Type: " + ___;
        String line6 = ____ + isLocalCitizen;
        ____

        //store the output to variable named output
        String output = ___ + "\n" + ___+ "\n" + line3+ "\n" + line4 + "\n" + line5 + "\n" + ___;

        //print out the output
        System.out.println(___);

        return output;
    }

    public static String task2(String name){
        // Your code here
        // ...

        //store all alphabet to single string
        //each alphabet with its index: a -> 0, b->1. ... z ->25
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        //change the input to lowercase, since tha alphabets are all in lowercase
        ____;

        //set the key

        int key = ___;

        //shift each character to 5 places right, if more than 25 then it back to 0
        String k1 = ""+alphabet.charAt((___) + key) ___ ___);
        String k2 = ""+___;
        ___
                ___
        ___

                //change the first character to upper case
                ___

        //generate the output
        String output = ____

        //print out the output
        ___

        //return the output
        return output;
    }

    public static String task3(String NumberOp){
        // Your code here
        // ...

        String output="";
        String partA="";
        String partB="";

        //you should need method defined below to convert from number to text e.g. 1--> satu, 2--> dua
        output=readIt(partA)+" puluh "+readIt(partB);
        System.out.println(output);

        return output;
    }

    static String readIt(String input){
        //your code goes here


        return input;
    }
}
