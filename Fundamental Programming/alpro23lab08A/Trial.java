import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Trial {
    public static int cost = 0;
    public static String path = "";
    public static void main(String[] args) {
        //your code goes here
        //Variable Declaration
        Scanner sc = new Scanner(Main.class.getResourceAsStream("costmatrix.txt"));
        int testcase = sc.nextInt();
        String vocabulary = "XABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for(int i = 1; i <= testcase; i++){
            //Matrix Dimension Declaration
            int numOfCities = sc.nextInt();
            int cityMap[][] = new int[numOfCities + 1][numOfCities + 1];

            //Filling in Matrix with values
            for(int j = 0; j <= numOfCities; j++){
                for(int z = 0; z <= numOfCities; z++){
                    cityMap[j][z] = sc.nextInt();
                }
            }

            //Output:
            //Iteration of test cases
            System.out.println("Test Case :" + i);
            //Mapping the cities with its corresponding cost
            for(int j = 0; j <= numOfCities + 1; j++) {
                for (int z = 0; z <= numOfCities + 1; z++) {
                    if (j == 0 && z == 0) {
                        System.out.print("  ");
                    } else if (j == 0) {
                        System.out.print(vocabulary.charAt(z - 1) + " ");
                    } else if (z == 0) {
                        System.out.print(vocabulary.charAt(j - 1) + " ");
                    } else {
                        for (int m = 0; m <= numOfCities; m++) {
                            System.out.print(cityMap[j - 1][m] + " ");
                        }
                        break;
                    }
                }
                System.out.println();
            }

            //Analyzing its best routes
            String bestRoutes = "X--";

            //recursive goes here
            boolean[] v = new boolean[numOfCities + 1];
            v[0] = true;
            int ans = Integer.MAX_VALUE;

            tsp(cityMap, v, 0, numOfCities + 1, 1, 0, ans, "");

            System.out.println("Best Route:" + bestRoutes + Trial.path + "--X (" + Trial.cost + ")");
        }
    }
    static int tsp(int[][] graph, boolean[] v, int currPos, int numOfCities, int count, int cost, int ans, String path) {
        String vocabulary = "XABCDEFGHIJKLMNOPQRSTUVWXYZ";

        // If last node is reached and it has a link
        // to the starting node i.e the source then
        // keep the minimum value out of the total cost
        // of traversal and "ans"
        // Finally return to check for more possible values
        if (count == numOfCities && graph[currPos][0] > 0) {
            //ans = Math.min(ans, cost + graph[currPos][0]);
            if(ans > cost + graph[currPos][0]){
                ans = cost + graph[currPos][0];
                Trial.path = path;
                return ans;
            } else {
                return ans;
            }
        }

        // BACKTRACKING STEP
        // Loop to traverse the adjacency list
        // of currPos node and increasing the count
        // by 1 and cost by graph[currPos,i] value
        for (int i = 0; i < numOfCities; i++) {
            if (v[i] == false && graph[currPos][i] > 0) {
                // Mark as visited
                v[i] = true;
                ans = tsp(graph, v, i, numOfCities, count + 1, cost + graph[currPos][i], ans, path += "" + vocabulary.charAt(i));
//                path = path.substring(0, path.length()-2);
                // Mark ith node as unvisited
                v[i] = false;
            }

        }

        Trial.cost = ans;
        return ans;
    }
}
