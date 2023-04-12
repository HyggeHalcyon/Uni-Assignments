import java.util.Scanner;
public class Trial {
    public static void main(String[] args){
        Scanner sc = new Scanner(Main.class.getResourceAsStream("receipt.txt"));
        System.out.println("Receipt");
        System.out.println("Category Name\t|\tCount\t|\tSubtotal");
        String line;
        String[] lineSplit;
        String itemName = " ";
        int price;
        String[] itemNameSplit;
        String category;

        int no = 1;
        int totalHat = 0;
        int totalShirt = 0;
        int totalPants = 0;
        int totalBag = 0;
        int totalOthers = 0;
        int totalitem = 0;

        double hatPrice = 0.0;
        double shirtPrice = 0.0;
        double pantsPrice = 0.0;
        double bagPrice = 0.0;
        double othersPrice = 0.0;
        double totalPrice = 0.0;

        while(sc.hasNextLine()){
            line = sc.nextLine();
            lineSplit = line.split(", ");

            itemName = lineSplit[0];
            price = Integer.parseInt(lineSplit[1]);

            if (itemName.contains("hat"))
            {
                totalHat = totalHat++;
                hatPrice = hatPrice+price;
                break;
            }
            else if (itemName.contains("shirt"))
            {
                totalShirt = totalShirt++;
                shirtPrice = shirtPrice+price;
                break;
            }else if (itemName.contains("pants"))
            {
                totalPants = totalShirt++;
                pantsPrice = pantsPrice+price;
                break;
            }else if (itemName.contains("bag"))
            {
                totalBag = totalBag++;
                bagPrice = bagPrice+price;
                break;
            }
            else
            {
                totalOthers = totalOthers++;
                othersPrice = othersPrice+price;
            }
        }

        System.out.println("Shirt\t\t\t|\t" + totalShirt + "\t\t|\t" + shirtPrice);
        System.out.println("Pants\t\t\t|\t" + totalPants + "\t\t|\t" + pantsPrice);
        System.out.println("Hat\t\t\t\t|\t" + totalHat + "\t\t|\t" + hatPrice);
        System.out.println("Bag\t\t\t\t|\t" + totalBag + "\t\t|\t" + bagPrice);
        System.out.println("Others\t\t\t|\t" + totalOthers + "\t\t|\t" + othersPrice);

        totalitem = totalShirt + totalPants + totalBag + totalHat + totalOthers;
        System.out.println("Total Item: " + totalitem);

        double discount = 100000 + (0.05*pantsPrice);
        double pantsAfterDiscount = 00;

        if (pantsPrice>1000000){
            pantsAfterDiscount = pantsPrice-discount;
        }

        totalPrice = shirtPrice + pantsPrice + hatPrice + bagPrice + othersPrice;
        System.out.println("Total Price: " + totalPrice);
        System.out.println("You saved " + discount +":)");
    }
}

