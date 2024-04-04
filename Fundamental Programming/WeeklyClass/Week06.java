import java.util.Scanner;
public class Week06 {
    public static void main1() {
        //looping with for

        for (int i = 1; i <= 5; i++) {
            System.out.print("#");
        }

        System.out.println();
        int i = 1;
        while (i <= 5) {
            System.out.print("#");
            i++;
        }

        System.out.println();

        i = 1;
        do {
            System.out.print("#");
            i++;
        } while (i <= 5);
    }

    public static void main2() {
        Scanner read = new Scanner(System.in);
        int nob;
        int sum = 0;
        do {
            System.out.println("Enter the number of book (enter -1 when finished):");
            nob = read.nextInt();
            if (nob != -1) sum += nob;

        } while (nob != -1);
        System.out.println("The total number of book is:" + sum);
    }

    public static void main3() {
        // your code goes here..
        int a[] = {20, 23, 25, 100};

        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
        System.out.println();
        for (int i = a.length - 1; i >= 0; i--) System.out.print(a[i] + " ");
        System.out.println();

        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("sum: " +sum);
        System.out.println("avg: " + sum / a.length);

        int min = a[0];
        int max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        System.out.println("min: " + min);
        System.out.println("max: " + max);
    }
}
