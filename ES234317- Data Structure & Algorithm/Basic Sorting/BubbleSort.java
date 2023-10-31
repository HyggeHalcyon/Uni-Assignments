import java.util.Arrays;

public class BubbleSort {
    static public void main(String[] args){
        int[] pool = {85, 93, 52, 48, 37};
        bubbleSort(pool);
        System.out.printf("Sorted Array: %s\n", Arrays.toString(pool));
    }

    static void bubbleSort(int[] pool){
        int n = pool.length;

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(pool[j] > pool[j + 1]){
                    // swap
                    int temp = pool[j];
                    pool[j] = pool[j + 1];
                    pool[j + 1] = temp;
                }

            }
        }
    }
}
