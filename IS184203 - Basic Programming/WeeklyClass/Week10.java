/**
 * Main class of the Java program.
 */

public class Week10 {

    public static void main() {
        int [][] M = {
                {1,3,5,7,1},
                {1,1,1,1,1},
                {0,2,4,6,1},
                {9,10,15,10,1},
                {0,0,0,0,1},
                {1,1,1,1,1}
        };

        //print all numbers
        /*
        for(int i=0;i<M.length;i++)
        {
            for(int j=0;j<M[0].length;j++){
                System.out.print(M[i][j]+"\t");
            }
            System.out.println();
        }*/
        //print number on odd row only

        /*
        for(int i=0;i<M.length;i++)
        {
            if(i%2==0){
                for(int j=0;j<M[0].length;j++){

                System.out.print(M[i][j]+"\t");
                }
                System.out.println();
            }

        }
        */
        /*
        for(int i=0;i<M.length;i++)
        {
            if(i%2==1) continue;

                for(int j=0;j<M[0].length;j++){
                    System.out.print(M[i][j]+"\t");
                }
                System.out.println();
        }
        */
        /*
        for(int i=0;i<M.length;i++)
        {
            if(i==2) break;

                for(int j=0;j<M[0].length;j++){
                    System.out.print(M[i][j]+"\t");
                }
                System.out.println();
        }
        */
        /*
        for(int i=0;i<M.length;i++)
        {
                for(int j=0;j<M[0].length;j++){
                    if(j==2) break;
                    System.out.print(M[i][j]+"\t");
                }
                System.out.println();
        }*/

        for(int i=0;i<M.length;i++)
        {
            for(int j=0;j<M[0].length;j++){
                if(i==j || (i+j)==4)
                    System.out.print(M[i][j]+"\t");
                else System.out.print(" "+"\t");
            }
            System.out.println();
        }


    }
}
