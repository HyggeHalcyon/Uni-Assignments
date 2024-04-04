import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner readFile = new Scanner(Main.class.getResourceAsStream("boxingcompetition.txt"));
        String []fileInput;
        String input, flyweightTopScorer, featherweightTopScorer, name = "";
        int  loop, score;
        int flyweightTopScore = 0;
        int featherweightTopScore = 0;
        int recordedCompetition = Integer.parseInt(readFile.nextLine());

        System.out.println("Top Scorer");
        System.out.println("Category\t\t Top Score \t TopScorer");
        System.out.println("---------------------------------------");

        loop = Integer.parseInt(readFile.nextLine());
        for(int i = 0; i < loop*2; i++){
            input = readFile.nextLine();
            fileInput = input.split(",");

            name = fileInput[0];
            score = Integer.parseInt(fileInput[1]);

            if(input.contains("flyweight")){
                if(score > flyweightTopScore) {
                    flyweightTopScorer = name;
                    flyweightTopScore = score;
                }
            }else {
                if(score > featherweightTopScore) {
                    featherweightTopScorer = name;
                    featherweightTopScore = score;
                }
            }
        }

        System.out.println("flyweight\t\t " +flyweightTopScore + "\t " );
        System.out.println("flyweight\t\t " +featherweightTopScore + "\t ");
    }
}
